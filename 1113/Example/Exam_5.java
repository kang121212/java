/*
 * 실습문제 5
 * 100에서 200까지 조절할 수 있는 수평 슬라이더와 레이블을 하나 만들고 사용자가 슬라이더를 움직이면
 * 레이블 컴포넌트에 수치로 보여주는 스윙 응용프로그램을 작성하라.
 */

package Exam;

import javax.swing.*;
import java.awt.event.*;

public class Exam_5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("슬라이더 에제");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel valueLabel = new JLabel("현재 값 : 100");
		valueLabel.setBounds(100,30,100,30);
		frame.add(valueLabel);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 100, 200, 100);
		slider.setBounds(50,80,200,50);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		frame.add(slider);
		
		slider.addChangeListener(e->{
			int value = slider.getValue();
			valueLabel.setText("현재 값: "+value);
		});
		
		frame.setVisible(true);
		
	}
}












