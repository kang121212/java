/*
 * 실습문제 5
 * GridLayout을 이용하여 실행결과와 같이 Color.WHITE, Color.Gray, Color.RED 등 
 * 16개의 색을 배경색으로 하는 4*4 바둑판을 구성하라.
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class Exam_5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Color Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(4,4));
		
		Color[] colors = {
	            Color.WHITE, Color.GRAY, Color.RED, Color.ORANGE,
	            Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
	            Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY,
	            new Color(128,0,128),
	            new Color(0,128,128),
	            new Color(255,192,203),
	            new Color(0,0,0)
		};
		for(int i=0; i<16; i++) {
			JButton button = new JButton(String.valueOf(i+1));
			button.setOpaque(true);
			button.setBorderPainted(false);
			button.setBackground(colors[i]);
			frame.add(button);
		}
		
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
