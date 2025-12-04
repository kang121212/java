package class11_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class AttendanceEditFrame extends JFrame {
    private String teacherId;
    private JTable table;
    private DefaultTableModel model;

    public AttendanceEditFrame(String teacherId) {
        super("전체 기록 수정");
        this.teacherId = teacherId;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        initUI();
        loadAttendance();
    }
    private void initUI() {
        model = new DefaultTableModel(new Object[]{"No","ID","날짜","교시","상태"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        table.setRowHeight(25);
        JButton updateBtn = new JButton("상태 변경");
        updateBtn.addActionListener(e -> updateStatus());
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(updateBtn, BorderLayout.SOUTH);
    }
    private void loadAttendance() {
        model.setRowCount(0);
        try(Connection conn = ManageProgram.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT attendance_id, student_id, date, period, status FROM Attendance WHERE teacher_id=? ORDER BY date DESC, period ASC")) {
            ps.setString(1, teacherId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
        } catch(SQLException e) { e.printStackTrace(); }
    }
    private void updateStatus() {
        int r = table.getSelectedRow();
        if(r<0) return;
        String[] ops = {"출석","지각","결석","조퇴"};
        String s = (String)JOptionPane.showInputDialog(this,"변경할 상태:", "수정", JOptionPane.PLAIN_MESSAGE, null, ops, model.getValueAt(r,4));
        if(s==null) return;
        try(Connection conn = ManageProgram.getConnection(); PreparedStatement ps = conn.prepareStatement("UPDATE Attendance SET status=? WHERE attendance_id=?")) {
            ps.setString(1, s); ps.setInt(2, (Integer)model.getValueAt(r, 0));
            ps.executeUpdate(); model.setValueAt(s, r, 4);
            JOptionPane.showMessageDialog(this, "수정됨");
        } catch(SQLException e) { e.printStackTrace(); }
    }
}