package class11_20;

import javax.swing.*;
import java.awt.*;

public class MyName extends JFrame {
    public MyName() {
        setTitle("내이름 출력하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(500, 500);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            // "김"
            g.drawLine(10, 10, 30, 10);
            g.drawLine(30, 10, 30, 30);
            g.drawLine(50, 10, 50, 30);
            g.drawRect(20, 40, 30, 20);

            // "강"
            g.drawLine(70, 10, 90, 10);
            g.drawLine(90, 10, 90, 30);
            g.drawLine(100, 10, 100, 30);
            g.drawLine(100, 20, 110, 20);
            g.drawOval(80, 40, 20, 20);

            // "일"
            g.drawOval(130, 10, 20, 20);
            g.drawLine(160, 10, 160, 30);
            g.drawLine(135, 40, 160, 40);
            g.drawLine(160, 40, 160, 50);
            g.drawLine(160, 50, 135, 50);
            g.drawLine(135, 50, 135, 60);
            g.drawLine(135, 60, 160, 60);

            // ❤️ 하트 모양 추가
            g.setColor(Color.RED);
            int x = 220, y = 40; // 하트 위치
            // 왼쪽 원
            g.fillOval(x, y, 20, 20);
            // 오른쪽 원
            g.fillOval(x + 20, y, 20, 20);
            // 아래 삼각형
            int[] heartX = {x, x + 40, x + 20};
            int[] heartY = {y + 10, y + 10, y + 40};
            g.fillPolygon(heartX, heartY, 3);
        }
    }

    public static void main(String[] args) {
        new MyName();
    }
}