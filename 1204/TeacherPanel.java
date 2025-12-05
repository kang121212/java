package class11_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;

public class TeacherPanel extends JPanel {
    private MainFrame mainFrame;
    private String tId, tClass;
    private DefaultTableModel model;
    private JComboBox<String> dateBox;
    private JTable table;

    public TeacherPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.setBackground(new Color(230, 240, 255));
        LocalDate now = LocalDate.now();
        dateBox = new JComboBox<>(new String[]{now.toString(), now.minusDays(1).toString()});
        JButton logoutBtn = new JButton("로그아웃");
        top.add(new JLabel("   📅 날짜: ")); top.add(dateBox);
        top.add(new JSeparator(SwingConstants.VERTICAL)); top.add(logoutBtn);
        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"학번","이름","상태"}, 0);
        table = new JTable(model); table.setRowHeight(35);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel right = new JPanel(new GridLayout(8,1,5,5));
        right.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JButton[] btns = {new JButton("학생추가"), new JButton("전원출석"), new JButton("출석"), new JButton("지각"), new JButton("결석"), new JButton("조퇴"), new JButton("통계"), new JButton("저장")};
        btns[0].setBackground(new Color(255, 240, 200)); btns[1].setBackground(new Color(200, 255, 200)); btns[7].setBackground(new Color(200, 200, 255));
        for(JButton b : btns) right.add(b);
        add(right, BorderLayout.EAST);

        dateBox.addActionListener(e -> loadData());
        logoutBtn.addActionListener(e -> mainFrame.showLogin());
        
        btns[0].addActionListener(e -> new StudentAddDialog(mainFrame, tClass, this::loadData).setVisible(true));
        btns[1].addActionListener(e -> setAll("출석"));
        btns[2].addActionListener(e -> setSel("출석")); btns[3].addActionListener(e -> setSel("지각"));
        btns[4].addActionListener(e -> setSel("결석")); btns[5].addActionListener(e -> setSel("조퇴"));
        btns[6].addActionListener(e -> new StatisticsDialog(mainFrame, tId, tClass).setVisible(true));
        btns[7].addActionListener(e -> saveData());
    }

    public void setTeacherInfo(String id, String name, String cls) {
        this.tId = id; this.tClass = cls; loadData();
    }

    private void loadData() {
        model.setRowCount(0); String date = (String)dateBox.getSelectedItem(); String[] p = tClass.split("-");
        try(Connection c = ManageProgram.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT S.student_id, S.name, A.status FROM Students S LEFT JOIN Attendance A ON S.student_id=A.student_id AND A.date=? AND A.teacher_id=? WHERE S.grade=? AND S.class=? ORDER BY S.student_id");
            ps.setString(1, date); ps.setString(2, tId); ps.setInt(3, Integer.parseInt(p[0])); ps.setString(4, p[1]);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)==null?"":rs.getString(3)});
        } catch(Exception e) { e.printStackTrace(); }
    }

    private void setAll(String s) { for(int i=0; i<model.getRowCount(); i++) model.setValueAt(s, i, 2); }
    private void setSel(String s) { for(int r : table.getSelectedRows()) model.setValueAt(s, r, 2); }
    
    private void saveData() {
        try(Connection c = ManageProgram.getConnection()) {
            c.setAutoCommit(false); String date = (String)dateBox.getSelectedItem();
            PreparedStatement d = c.prepareStatement("DELETE FROM Attendance WHERE date=? AND teacher_id=?");
            d.setString(1, date); d.setString(2, tId); d.executeUpdate();
            
            PreparedStatement i = c.prepareStatement("INSERT INTO Attendance(student_id,teacher_id,date,period,status) VALUES(?,?,?,1,?)");
            for(int r=0; r<model.getRowCount(); r++) {
                String st = (String)model.getValueAt(r, 2); if(st==null || st.isEmpty()) continue;
                i.setString(1, (String)model.getValueAt(r,0)); i.setString(2, tId); i.setString(3, date); i.setString(4, st); i.addBatch();
            }
            i.executeBatch(); c.commit(); JOptionPane.showMessageDialog(this, "저장 완료");
        } catch(Exception e) { e.printStackTrace(); }
    }
}