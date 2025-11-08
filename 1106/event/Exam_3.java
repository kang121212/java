/*
 * 실습문제 3
 * JLabel을 활용하여 "Love Java"를 출력하고 왼쪽 화살표(<Left>키)를 입력할 때마다
 * "ove Javal", "ve JavaLo", "e JavaLov"와 같이 한 문자씩 왼쪽으로 회전하는 프로그램을 작성하라.
 * 
 */

package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("문자열 회전");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Love Java");
		frame.add(label);
		
		frame.setFocusable(true);
		frame.requestFocus();
		
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				String text = label.getText();
				if(text.length()>0) {
					String rotated = text.substring(1)+text.charAt(0);
					label.setText(rotated);
				}
			}
		});
		
		frame.setVisible(true);
	}
}
