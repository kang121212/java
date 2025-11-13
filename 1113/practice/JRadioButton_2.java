package class11_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JRadioButton_2 extends JFrame{
	private JLabel imageLabel;	//이미지 라벨
	
	public JRadioButton_2() {
		setTitle("라디오 버튼 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup();
		
		JRadioButton car = new JRadioButton("차");
		JRadioButton boat = new JRadioButton("배",true);
		JRadioButton plane = new JRadioButton("비행기");
		
		g.add(car);
		g.add(boat);
		g.add(plane);
		
		c.add(car);
		c.add(boat);
		c.add(plane);
		
		ImageIcon carIcon = new ImageIcon("C:\\java\\workspace\\class11_13\\src\\class11_13\\car.png");
		ImageIcon boatIcon = new ImageIcon("C:\\java\\workspace\\class11_13\\src\\class11_13\\boat.png");
		ImageIcon planeIcon = new ImageIcon("C:\\java\\workspace\\class11_13\\src\\class11_13\\plane.png");
		
		imageLabel = new JLabel(boatIcon);
		c.add(imageLabel);
		
		car.addActionListener(e-> imageLabel.setIcon(carIcon));
		boat.addActionListener(e-> imageLabel.setIcon(boatIcon));
		plane.addActionListener(e-> imageLabel.setIcon(planeIcon));
		
		setSize(500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JRadioButton_2();
	}
}














