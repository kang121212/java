/*
- 실습문제 10
- 실행 예시를 참고하여 스윙 프로그램을 작성하라. 'm'키를 입력할때마다
- 80*80 크기의 블록(JLabel)을 (100,100) 위치에 랜덤한 배경색으로 만들고,
- 만들어진 모든 블록들은 마우스로 드래깅하면 원하는 위치로 이동시킬 수 있게 한다. */

package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Exam_10 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("블록 생성 및 드래그");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null); // 절대 위치 지정
        panel.setBackground(Color.WHITE);
        frame.add(panel);

        panel.setFocusable(true);
        panel.requestFocusInWindow();

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm') {
                    JLabel block = new JLabel();
                    block.setOpaque(true);
                    block.setBackground(randomColor());
                    block.setBounds(100, 100, 80, 80);
                    panel.add(block);
                    panel.repaint();

                    // 드래그 기능 추가
                    block.addMouseListener(new MouseAdapter() {
                        Point offset;

                        @Override
                        public void mousePressed(MouseEvent e) {
                            offset = e.getPoint();
                            block.putClientProperty("offset", offset);
                        }
                    });

                    block.addMouseMotionListener(new MouseMotionAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            Point offset = (Point) block.getClientProperty("offset");
                            if (offset != null) {
                                Point p = SwingUtilities.convertPoint(block, e.getPoint(), panel);
                                block.setLocation(p.x - offset.x, p.y - offset.y);
                            }
                        }
                    });
                }
            }
        });

        frame.setVisible(true);
    }

    // 랜덤 색상 생성 메서드
    private static Color randomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}