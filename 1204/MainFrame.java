package class11_27;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    // 각 화면 패널들
    private LoginPanel loginPanel;
    private AdminPanel adminPanel;
    private TeacherPanel teacherPanel;
    private StudentPanel studentPanel;

    public MainFrame() {
        super("통합 출석 관리 시스템");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // 패널 생성
        loginPanel = new LoginPanel(this);
        adminPanel = new AdminPanel(this);
        teacherPanel = new TeacherPanel(this);
        studentPanel = new StudentPanel(this);

        // 패널 등록
        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(adminPanel, "ADMIN");
        mainPanel.add(teacherPanel, "TEACHER");
        mainPanel.add(studentPanel, "STUDENT");

        add(mainPanel);
        showLogin();
    }

    public void showLogin() {
        setTitle("로그인 - 통합 출석 관리 시스템");
        cardLayout.show(mainPanel, "LOGIN");
    }

    public void showAdmin() {
        setTitle("관리자 모드");
        adminPanel.refreshData();
        cardLayout.show(mainPanel, "ADMIN");
    }

    public void showTeacher(String id, String name, String cls) {
        setTitle("출석부 - " + name + " 선생님 (" + cls + ")");
        teacherPanel.setTeacherInfo(id, name, cls);
        cardLayout.show(mainPanel, "TEACHER");
    }

    public void showStudent(String id, String name, String grade, String cls) {
        setTitle("학생 포털 - " + name);
        studentPanel.setStudentInfo(id, name, grade, cls);
        cardLayout.show(mainPanel, "STUDENT");
    }
}