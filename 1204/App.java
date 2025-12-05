package class11_27;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        // [디자인] 윈도우 기본 스타일 강제 적용
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            setUIFont(new javax.swing.plaf.FontUIResource("맑은 고딕", Font.PLAIN, 13));
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
        }

        // DB 초기화 및 샘플 데이터 생성
        ManageProgram.seedSampleData();

        // 메인 윈도우 실행
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // 전체 폰트 설정 도우미
    private static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, f);
            }
        }
    }
}