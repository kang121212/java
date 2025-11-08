/*
 * 실습문제 4
 * 문제 3을 수정하여 실행 결과와 같이 각 버튼의 배경색을 서로 다르게 설정하라.
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GridLayout with Colors");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,10));
		
		Color[] colors = {
				Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
				Color.BLUE, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.GRAY
		};
		
		for( int i =1; i <=10; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.setOpaque(true);
			button.setBorderPainted(false);
			button.setBackground(colors[i-1]);
			frame.add(button);
		}
		
		frame.setSize(800, 200);
		frame.setVisible(true);
	}
}
