/*
 * 오픈 챌린지
 * 여러 패널과 컴포넌트를 가진 스윙 응용 프로그램을 만들어 보자. 그림과 같이 컨텐트팬에 BorderLayout 배치 관리자를
 * 설치하고, NORTH, Center, south 영역에는 Jpanel을 상속받은 패널을 붙인다.
 * north 패널에는 1개의 jlabel을 이용하여 "단어 조합 게임!" 문자열을 부착하고, 
 * 1개의 jbutton을 이용하여 "new Text" 버튼을 부착한다. 그리고 south 패널에는 jlabel과 jtextfield 컴포넌트를
 * 하나씩 붙인다. 마지막으로 center 패널에는 미리 준비된 문장"I can't help falling in love with you"을 단어들로
 * 분리하고, 각 단어를 center 패널 내 랜덤한 위치에 배치한다. 이때 x의 범위는 0~350, y의 범위는 0~180 사이로 한다.
 * 프레임의 크기는 400*300으로 한다. 이 문제는 단어 게임의 gui를 만드는 과정만 구현한다.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class OpenChallenge {
	public static void main(String[] args) {
		JFrame frame = new JFrame("단어 조합 게임");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,300);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel titleLabel = new JLabel("단어 조합 게임!");
		JButton newTextButton = new JButton("new Text");
		northPanel.add(titleLabel);
		northPanel.add(newTextButton);
		contentPane.add(northPanel, BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		JLabel inputLabel = new JLabel("단어 입력");
		JTextField inputField = new JTextField(20);
		southPanel.add(inputLabel);
		southPanel.add(inputField);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel(null);
		String sentence = "I can't help falling in love with you";
		String[] words = sentence.split(" ");
		Random rand = new Random();
		
		for(String word : words) {
			JLabel wordLabel = new JLabel(word);
		int x = rand.nextInt(351);
		int y = rand.nextInt(181);
		wordLabel.setBounds(x,y,word.length() *10+10, 20);
		centerPanel.add(wordLabel);
		}
		contentPane.add(centerPanel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}














