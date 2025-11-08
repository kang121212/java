/*
 * 스윙을 이용하여 실행 결과와 같은 모양의 GUI 응용프로그램을 작성하라. 컨텐트팬의
 * West 영역에는 GridLayout 배치 관리자를 사용하여 10개의 버튼을 배치하고, Center 영역에는 0~9 까지의 정수를
 * 랜덤하게 출력하라. 이들은 각각 JLabel 객체를 이용하여 출력하고 출력되는 좌표의 범위는 (50,50)~(200,200)이다.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Exam_10 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("별 위치 랜덤 출력");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(10,1,5,5));
		for(int i = 1; i<=10; i++) {
			JButton button = new JButton("Button "+i);
			buttonPanel.add(button);
		}
		contentPane.add(buttonPanel, BorderLayout.WEST);
		
		JPanel numberPanel = new JPanel(null);
		Random rand = new Random();
		for(int i=0; i<10; i++) {
			JLabel label = new JLabel(String.valueOf(i));
			int x=50+rand.nextInt(151);
			int y=50+rand.nextInt(151);
			label.setBounds(x,y,30,30);
			numberPanel.add(label);
		}
		contentPane.add(numberPanel, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
}
