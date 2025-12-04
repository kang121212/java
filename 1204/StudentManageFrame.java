package class11_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentManageFrame extends JFrame {
    private String classAssigned;
    private DefaultTableModel model;
    private JTable table;
    private JTextField idField, nameField;

    public StudentManageFrame(String classAssigned) {
        super("학생 관리 (" + classAssigned + ")");
        this.classAssigned = classAssigned;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        initUI();
        loadStudents();
    }
    private void initUI() {
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        idField = new JTextField(8); nameField = new JTextField(8);
        JButton addBtn = new JButton("추가"); JButton delBtn = new JButton("삭제");
        inputPanel.add(new JLabel("ID:")); inputPanel.add(idField);
        inputPanel.add(new JLabel("이름:")); inputPanel.add(nameField);
        inputPanel.add(addBtn); inputPanel.add(delBtn);
        add(inputPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new Object[]{"ID", "이름", "학년", "반"}, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        table.setRowHeight(25);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addBtn.addActionListener(e -> addStudent());
        delBtn.addActionListener(e -> deleteStudent());
    }
    private void loadStudents() {
        model.setRowCount(0);
        String[] parts = classAssigned.split("-");
        try (Connection conn = ManageProgram.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM Students WHERE grade=? AND class=?")) {
            ps.setInt(1, Integer.parseInt(parts[0])); ps.setString(2, parts[1]);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)});
        } catch (SQLException e) { e.printStackTrace(); }
    }
    private void addStudent() {
        if(idField.getText().isEmpty() || nameField.getText().isEmpty()) return;
        String[] parts = classAssigned.split("-");
        try (Connection conn = ManageProgram.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO Students VALUES (?,?,?,?)")) {
            ps.setString(1, idField.getText()); ps.setString(2, nameField.getText());
            ps.setInt(3, Integer.parseInt(parts[0])); ps.setString(4, parts[1]);
            ps.executeUpdate(); loadStudents();
            idField.setText(""); nameField.setText("");
            JOptionPane.showMessageDialog(this, "추가됨");
        } catch (SQLException e) { JOptionPane.showMessageDialog(this, "오류/중복ID: " + e.getMessage()); }
    }
    private void deleteStudent() {
        int r = table.getSelectedRow();
        if(r<0) return;
        try(Connection conn = ManageProgram.getConnection(); PreparedStatement ps = conn.prepareStatement("DELETE FROM Students WHERE student_id=?")) {
            ps.setString(1, (String)model.getValueAt(r, 0));
            ps.executeUpdate(); loadStudents();
        } catch(SQLException e) { e.printStackTrace(); }
    }
}