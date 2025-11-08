/*
 * 실습문제 5
 * 클릭 연습용 스윙 프로그램을 작성하라. "C"를 출력하는 JLabel을 하나 만들고
 * 초기 위치를(100,100)으로 하고, "C"를 클륵할때마다 랜덤한 위치로 움직이게 하라.
 */

package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Exam_5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("클릭 연습");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel label = new JLabel("C");
		label.setSize(20,20);
		label.setLocation(100,100);
		frame.add(label);
		
		Random rand = new Random();
		
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = rand.nextInt(frame.getContentPane().getWidth()-label.getWidth());
				int y = rand.nextInt(frame.getContentPane().getHeight()-label.getHeight());
				label.setLocation(x,y);
			}
		});
		frame.setVisible(true);
	}
}
