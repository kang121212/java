/*
 * 실습문제 7
 * 컨텐트팬에 버튼을 5개 부착하고, 모든 버튼의 표면에 0을 출력하고, 각 버튼이 클릭
 * 될때마다 클릭 횟수를 증가시켜 표면을 갱신하는 스윙 프로그램을 작성하라.
 */

package Chapter_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_7 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("버튼 클릭 카운터");
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JButton[] buttons = new JButton[5];
		int[] counts = new int [5];
		for(int i = 0; i<buttons.length; i++) {
			JButton btn = new JButton("0");
			int index = i;
			
			btn.addActionListener(e->{
				counts[index]++;
				btn.setText(String.valueOf(counts[index]));
			});
			buttons[i] = btn;
			frame.add(btn);
		}
		frame.setVisible(true);
	}
}
