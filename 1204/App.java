package class11_27;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // UI를 윈도우 스타일로 깔끔하게
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        // DB 테이블 생성 및 기초 데이터 세팅
        ManageProgram.seedSampleData();

        // 로그인 창 실행
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}