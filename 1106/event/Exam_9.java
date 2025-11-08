/*
 * 실습문제 9
 * JLabel을 활용하여 "Love Java"를 출력하고, "Love Java" 글자 위에 마우스를 올려
 * 마우스 휠을 위로 굴리면 글자가 ㅈ가아지고, 아래로 굴리면 글자가 커지도록 프로그램을 작성하라.
 * 폰트 크기는 한 번에 5픽셀씩 작아지거나 커지도록 하고, 5픽셀 이하로 작아지지 않도록 하라.
 */

package Chapter_10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_9 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("폰트 크기 조절");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Love Java");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        frame.add(label);
        
        label.addMouseWheelListener(new MouseWheelListener() {
        	int fontSize = 30;
        	
        	public void mouseWheelMoved(MouseWheelEvent e) {
        		int notches = e.getWheelRotation();
        		if(notches <0) {
        			fontSize = Math.max(5, fontSize -5);
        			
        		} else {
        			fontSize += 5;
        		}
        		label.setFont(new Font("Serif", Font.BOLD, fontSize));
        	}
        });
        frame.setVisible(true);
	}
}
