/*
 * 실습문제 6
 * 실행 예시와 같은 모양의 GUI 응용프로그램을 작성하라. 컨텐트팬의 WEST 영역에는 GridLayout 그리드 배치 관리자를 사용하여
 * 11개의 버튼을 배치하고, CENTER 영역에는 배치관리자 없이 0~9까지의 정수를 랜덤하게 출력하라.
 * 정수가 출력되는 좌표의 범위는 (50,50)~(200,200)이다. 그 후 WEST 영역의 버튼을 클릭하면
 * 버튼의 배경색과 동일하게 정수의 글자색을 변경하고, Center 영역을 마우스 클릭하면 정수를 랜덤하게 재배치하라.
 * 
 */

package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Exam_6 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("색상 버튼과 숫자");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JPanel westPanel = new JPanel(new GridLayout(11, 1));
		Color[] colors= {
				Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
	            Color.BLUE, Color.MAGENTA, Color.PINK, Color.GRAY, Color.DARK_GRAY, Color.BLACK
	            };
		JPanel centerPanel = new JPanel(null);
		centerPanel.setBackground(Color.WHITE);
		
		JLabel numberLabel = new JLabel(String.valueOf(new Random().nextInt(10)));
		numberLabel.setSize(50,50);
		numberLabel.setLocation(randomX(), randomY());
		centerPanel.add(numberLabel);
		
		for(Color color : colors) {
			JButton btn = new JButton();
			btn.setBackground(color);
			btn.setOpaque(true);
			btn.setBorderPainted(false);
			btn.addActionListener(e->numberLabel.setForeground(btn.getBackground()));
			westPanel.add(btn);
		}
		
		centerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numberLabel.setLocation(randomX(), randomY());
            }
        });

        frame.add(westPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
	private static int randomX() {
		return 50+ new Random().nextInt(151);
	}
	private static int randomY() {
		return 50 + new Random().nextInt(151);
	}
}





















