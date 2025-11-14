/*
 * 실습문제 7
 * 수평 슬라이더를 만들고, 슬라이더를 움직이면 문자열 레이블의 글자 크기를 조절할 수 있는 스윙
 * 프로그램을 작성하라.폰트 크기는 1픽셀에서 100픽셀까지이며, 클 눔금 간격은 20, 작은 눈금 간격은 5로 하라.
 * 슬라이더는 컨텐트팬의 NORTH 영역에, 문자열은 CENTER 에 부착하라.
 */

package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Exam_7 extends JFrame{
	private JLabel label;
	private JSlider slider;
	
	public Exam_7() {
		setTitle("폰트 크기 조절 슬라이더");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		
		label = new JLabel("폰트 크기를 조절해보세요!!", JLabel.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 20));
		add(label, BorderLayout.CENTER);
		
		slider = new JSlider(JSlider.HORIZONTAL, 1, 100, 20);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		add(slider,BorderLayout.NORTH);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int fontSize = slider.getValue();
				label.setFont(new Font("Serif", Font.PLAIN, fontSize));
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new Exam_7();
	}
}
