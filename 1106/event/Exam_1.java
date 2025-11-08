/*
 * 실습문제 1
 * JLabel 컴포넌트를 활용하여 텍스트를 출력하고, 텍스트 위에 마우스를 올리면 "Love Java"가,
 * 마우스를 내리면 "사랑해 자바"가 출력되도록 스윙 프로그램을 작성하라. JLabel 컴포넌트는 Mouse 이벤트를 받을 수 있다.
 * 
 */

package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mouse Event Example");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("사랑해 자바");
		frame.add(label);
		
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label.setText("Love Java");
			}
			public void mouseExited(MouseEvent e) {
				label.setText("사랑해 자바");
			}
		});
		
		frame.setVisible(true);
	} 
}




















