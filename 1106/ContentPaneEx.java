package class11_06;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public ContentPaneEx() {
		setTitle("ContentPane과 JFrame 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ContentPane = getContentPane();
		ContentPane.setBackground(Color.ORANGE);
		ContentPane.setLayout(new FlowLayout());
		
		ContentPane.add(new JButton("OK"));
		ContentPane.add(new JButton("Cancel"));
		ContentPane.add(new JButton("Ignore"));
		
		setSize(300,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ContentPaneEx();
	}
}