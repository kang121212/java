/*
 * 실습문제 9
 * 스윙을 이용하여 실행 결과와 같은 모양의 GUI 응용프로그램을 작성하라.
 * 프로그램을 실행하면 총 15개의 별("*") 문자가 랜덤한 위치에 출력되게 하라.
 * 이 문제에 있는 버튼들을 클릭할때 별의 위치를 재조정하는 등 이벤트를 처리하는 것은 10장의 실습 문제에서 다룬다.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Exam_9{
	public static void main(String[] args) {
		JFrame frame = new JFrame("별 위치 랜덤 출력");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		
		JPanel starPanel = new JPanel() {
			private final int STAR_COUNT = 15;
			private final Point[] starPositions = new Point[STAR_COUNT];
			private final Random rand = new Random();
			{
				for(int i = 0; i<STAR_COUNT; i++) {
					int x=rand.nextInt(380);
					int y=rand.nextInt(380);
					starPositions[i] = new Point(x,y);
				}
			}
			
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for(Point p : starPositions) {
					g.drawString("*", p.x, p.y);
				}
			}
		};
		frame.add(starPanel);
		frame.setVisible(true);
	}
	
}


