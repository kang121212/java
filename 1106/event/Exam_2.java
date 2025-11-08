/*
 * 실습문제 2
 * 컨텐트팬의 배경색은 초록색으로 하고 마우스를드래깅 하는 동안만 노란색으로 변하는 
 * 스윙 프로그램을 작성하라.
 */

package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("드래깅 배경색 변경");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = frame.getContentPane();
		contentPane.setBackground(Color.GREEN);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				contentPane.setBackground(Color.YELLOW);
			}
		});
		
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				contentPane.setBackground(Color.GREEN);
			}
		});
		
		frame.setVisible(true);
	}
}
