package class11_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentPanel extends JPanel {
    private MainFrame mainFrame;
    private DefaultTableModel model;
    private JLabel infoLabel;
    private String sId;

    public StudentPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        top.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        infoLabel = new JLabel("학생 정보 로딩중...");
        infoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        JButton logoutBtn = new JButton("로그아웃");
        top.add(infoLabel, BorderLayout.CENTER); top.add(logoutBtn, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"날짜","교시","상태","선생님"}, 0);
        JTable table = new JTable(model); table.setRowHeight(30);
        add(new JScrollPane(table), BorderLayout.CENTER);

        logoutBtn.addActionListener(e -> mainFrame.showLogin());
    }

    public void setStudentInfo(String id, String name, String grade, String cls) {
        this.sId = id;
        infoLabel.setText(String.format("👋 환영합니다! %s 학생 (%s학년 %s반)", name, grade, cls));
        loadHistory();
    }

    private void loadHistory() {
        model.setRowCount(0);
        try(Connection c = ManageProgram.getConnection()) {
            PreparedStatement ps = c.prepareStatement("SELECT A.date, A.period, A.status, T.name FROM Attendance A JOIN Teachers T ON A.teacher_id=T.teacher_id WHERE A.student_id=? ORDER BY date DESC");
            ps.setString(1, sId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) model.addRow(new Object[]{rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)});
        } catch(Exception e) { e.printStackTrace(); }
    }
}