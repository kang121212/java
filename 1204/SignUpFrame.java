package class11_27;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SignUpFrame extends JFrame {
    private JTextField idField = new JTextField(10);
    private JTextField nameField = new JTextField(10);
    private JTextField classField = new JTextField(10); // 예: 3-2
    private JTextField keyField = new JTextField(10);
    private JButton registerBtn = new JButton("등록하기");

    public SignUpFrame() {
        super("교사 회원가입");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        panel.add(new JLabel("아이디(ID):")); panel.add(idField);
        panel.add(new JLabel("이름:")); panel.add(nameField);
        panel.add(new JLabel("담당 반 (예: 3-1):")); panel.add(classField);
        panel.add(new JLabel("비밀번호(Key):")); panel.add(keyField);
        panel.add(new JLabel("")); panel.add(registerBtn);

        add(panel);

        registerBtn.addActionListener(e -> registerTeacher());
    }

    private void registerTeacher() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String cls = classField.getText().trim();
        String key = keyField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || cls.isEmpty() || key.isEmpty()) {
            JOptionPane.showMessageDialog(this, "모든 정보를 입력해주세요.");
            return;
        }

        try (Connection conn = ManageProgram.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO Teachers VALUES (?, ?, ?, ?)")) {
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, cls);
            ps.setString(4, key);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "회원가입 완료! 로그인해주세요.");
            dispose();
        } catch (SQLException e) {
            if(e.getMessage().contains("UNIQUE")) {
                JOptionPane.showMessageDialog(this, "이미 존재하는 ID입니다.");
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "가입 실패: " + e.getMessage());
            }
        }
    }
}