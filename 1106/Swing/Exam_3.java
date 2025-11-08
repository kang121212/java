/*
 * 실습문제 3 
 * GridLayout을 사용하여 실행 결과와 같이 한 줄에 10개의 버튼을 동일한 크기로
 * 배치하는 스윙 프로그램을 작성하라.
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GridLayout Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(1,10));
		
		for(int i=1; i<=10; i++) {
			frame.add(new JButton(String.valueOf(i)));
		}
		frame.setSize(800, 100);
		frame.setVisible(true);
	}
}
