/*
 * 실습문제 6
 * 10*10 크기의 JLabel 컴포넌트 20개를 프레임 내에 (10,10) 위치에서 (250,250)의
 * 사각형 영역 내 랜덤한 위치에 출력하는 스윙 프로그램을 작성하라. 프레임의 크기는 300*300으로하고
 * JLabel의 배경색은 랜덤하게 하라.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Exam_6 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Random JLabel Placement");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLayout(null);
		
		Random rand = new Random();
		
		for(int i=0; i<20; i++) {
			JLabel label = new JLabel();
			label.setSize(10,10);
			label.setOpaque(true);
			
			int x = 10 + rand.nextInt(241);
			int y = 10 + rand.nextInt(241);
			label.setLocation(x,y);
			
			Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
			label.setBackground(randomColor);
			
			frame.add(label);
		}
		frame.setVisible(true);
	}
}
