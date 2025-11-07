package class11_06;

import javax.swing.*;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = 1L;	//에러 나오면 삽입
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("300*300 스윙 프레임 만들기");
		
		setSize(300,300);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MyFrame();	//에러 나오면 mf 지운다
	}
}
