/*
 * 실습문제 8
 * 이미지 갤러리를 만들어보자. 다음과 같이 2개의 라디오버튼과 이미지가 출력된다.
 * 이미지를 클릭하면 다음 이미지를 보여준다. 프로젝트의 images 폴더에 있는 모든 이미지를 대상으로 한다.
 * 그러므로 프로그램 실행 전 images 폴더를 만들고 여러개의 이미지를 저장해 두어야 한다.
 * left 버튼이 선택된 상태면 왼쪽으로 넘기는 순서로 이미지를 보여주고, right 라디오 버튼이 선택된 상태면
 * 그 반대로 진행된다.
 */

package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class Exam_8 extends JFrame{
	private JLabel imageLabel;
	private JRadioButton leftButton, rightButton;
	private ArrayList<ImageIcon> imageList = new ArrayList<>();
	private int currentIndex = 0;
	
	public Exam_8() {
		setTitle("이미지 갤러리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLayout(new BorderLayout());
		
		loadImages();
		
		imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(JLabel.CENTER);
		if(!imageList.isEmpty()) {
			imageLabel.setIcon(imageList.get(currentIndex));
		}
		add(imageLabel, BorderLayout.CENTER);
		
		imageLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				showNextImage();
			}
		});
		
		leftButton = new JRadioButton("Left");
		rightButton = new JRadioButton("Right");
		ButtonGroup group = new ButtonGroup();
		group.add(leftButton);
		group.add(rightButton);
		rightButton.setSelected(true);
		
		JPanel radioPanel = new JPanel();
		radioPanel.add(leftButton);
		radioPanel.add(rightButton);
		add(radioPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private void loadImages() {
		File dir = new File("images");
		if(!dir.exists() || !dir.isDirectory()) {
			JOptionPane.showMessageDialog(this, "images 폴더가 없다");
			return;
		}
		
		File[] files = dir.listFiles((d, name)->{
			String lower = name.toLowerCase();
			return lower.endsWith(".jpg")||lower.endsWith(".jpeg")||lower.endsWith(".png");
		});
		
		if(files != null) {
			for(File file : files) {
				imageList.add(new ImageIcon(file.getPath()));
			}
		}
	}
	
	private void showNextImage() {
		if(imageList.isEmpty()) return;
		
		if(leftButton.isSelected()) {
			currentIndex = (currentIndex -1 + imageList.size()) % imageList.size();
		} else {
			currentIndex = (currentIndex -1) + imageList.size();
		}
		
		imageLabel.setIcon(imageList.get(currentIndex));
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new Exam_8());
	}

}


























