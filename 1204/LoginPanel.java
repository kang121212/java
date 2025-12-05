package class11_27;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginPanel extends JPanel {
    private MainFrame mainFrame;
    private JTextField idField = new JTextField(15);
    private JPasswordField pwField = new JPasswordField(15);

    public LoginPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout());
        
        JPanel box = new JPanel(new GridLayout(4, 1, 10, 10));
        box.setBorder(BorderFactory.createTitledBorder(" 시스템 로그인 "));
        box.setPreferredSize(new Dimension(300, 250));

        JPanel p1 = new JPanel(new BorderLayout()); p1.add(new JLabel("ID"), BorderLayout.NORTH); p1.add(idField, BorderLayout.CENTER);
        JPanel p2 = new JPanel(new BorderLayout()); p2.add(new JLabel("Password"), BorderLayout.NORTH); p2.add(pwField, BorderLayout.CENTER);
        
        JButton loginBtn = new JButton("로그인");
        loginBtn.setBackground(new Color(220, 240, 255));
        loginBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        
        JButton joinBtn = new JButton("회원가입");
        
        box.add(p1); box.add(p2); box.add(loginBtn); box.add(joinBtn);
        add(box);

        loginBtn.addActionListener(e -> tryLogin());
        joinBtn.addActionListener(e -> new SignUpDialog(mainFrame).setVisible(true));
    }

    private void tryLogin() {
        String id = idField.getText().trim();
        String pw = new String(pwField.getPassword()).trim();
        if(id.isEmpty() || pw.isEmpty()) return;

        try (Connection conn = ManageProgram.getConnection()) {
            // 1. 교사/관리자 확인
            try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM Teachers WHERE teacher_id=? AND auth_key=?")) {
                ps.setString(1, id); ps.setString(2, pw);
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()) {
                        String role = rs.getString("role");
                        if("ADMIN".equals(role)) mainFrame.showAdmin();
                        else mainFrame.showTeacher(id, rs.getString("name"), rs.getString("class_assigned"));
                        clearFields(); return;
                    }
                }
            }
            // 2. 학생 확인
            try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM Students WHERE student_id=? AND auth_key=?")) {
                ps.setString(1, id); ps.setString(2, pw);
                try(ResultSet rs = ps.executeQuery()) {
                    if(rs.next()) {
                        mainFrame.showStudent(id, rs.getString("name"), String.valueOf(rs.getInt("grade")), rs.getString("class"));
                        clearFields(); return;
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "로그인 정보가 일치하지 않습니다.");
        } catch (Exception e) { e.printStackTrace(); }
    }
    private void clearFields() { idField.setText(""); pwField.setText(""); }
}