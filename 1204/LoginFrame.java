package class11_27;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LoginFrame extends JFrame {
    private JTextField teacherIdField = new JTextField(12);
    private JPasswordField authKeyField = new JPasswordField(12);
    private JButton loginButton = new JButton("로그인");
    private JButton signUpButton = new JButton("회원가입"); // [NEW]

    public LoginFrame() {
        super("교사 로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 220);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(8,8,8,8);
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.gridx = 0; gc.gridy = 0; panel.add(new JLabel("교사 ID:"), gc);
        gc.gridx = 1; panel.add(teacherIdField, gc);

        gc.gridx = 0; gc.gridy = 1; panel.add(new JLabel("인증 키(PW):"), gc);
        gc.gridx = 1; panel.add(authKeyField, gc);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(loginButton);
        btnPanel.add(signUpButton);

        gc.gridx = 0; gc.gridy = 2; gc.gridwidth = 2;
        panel.add(btnPanel, gc);

        add(panel);

        loginButton.addActionListener(e -> tryLogin());
        signUpButton.addActionListener(e -> new SignUpFrame().setVisible(true));
    }

    private void tryLogin() {
        String tid = teacherIdField.getText().trim();
        String key = new String(authKeyField.getPassword()).trim();

        if (tid.isEmpty() || key.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID와 인증 키를 입력하세요.");
            return;
        }

        try (Connection conn = ManageProgram.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM Teachers WHERE teacher_id=? AND auth_key=?")) {
            ps.setString(1, tid);
            ps.setString(2, key);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String tId = rs.getString("teacher_id");
                    String tName = rs.getString("name");
                    String tClass = rs.getString("class_assigned");

                    SwingUtilities.invokeLater(() -> {
                        new AttendanceFrame(tId, tName, tClass).setVisible(true);
                        dispose();
                    });
                } else {
                    JOptionPane.showMessageDialog(this, "로그인 실패: 정보가 올바르지 않습니다.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "DB 오류: " + ex.getMessage());
        }
    }
}