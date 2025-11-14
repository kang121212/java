/*
 * 실습문제 10
 * 흩뿌려진 단어들을 조합하여 한 줄의 텍스트를 완성하는 게임을 작성하라. 여러 줄의 텍스트를 미리 준비해두고, 
 * "New Text" 버튼을 클릭하면 이 중에서 한 줄을 선택한 후 단어를 분리하여 화면의 랜덤한 위치에 
 * 출력한다. 사용자는 단어를 순서대로 클릭하여 문장을 완성한다. 사용자가 단어를 클릭할 때마다 하단에 완성된 문장이 보이고, 사용자가
 * 문장을 바르게 완성하면 게임이 끝난다.
 */

package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Exam_10 extends JFrame{
	private ArrayList<String> sentences = new ArrayList<>();
	private ArrayList<JButton> wordButtons = new ArrayList<>();
	private JPanel wordPanel;
	private JLabel resultLabel;
	private JButton newTextButton;
	
	private String[] currentWords;
	private int currentIndex = 0;
	private StringBuilder userSentence = new StringBuilder();
	
	public Exam_10() {
		setTitle("단어 조합 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		setLayout(null);
		
		sentences.add("Java is a powerful programming language");
		sentences.add("Swing makes building GUIs easier");
		sentences.add("Practice makes perfect");
		sentences.add("Coding is fun and creative");
		
		wordPanel = new JPanel(null);
		wordPanel.setBounds(0, 50, 600, 350);
		add(wordPanel);
		
		resultLabel = new JLabel("문장을 완성하세요.", SwingConstants.CENTER);
		resultLabel.setBounds(0, 410, 600, 30);
		resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
		add(resultLabel);
		
		newTextButton = new JButton("New Text");
		newTextButton.setBounds(250, 10, 100, 30);
		newTextButton.addActionListener(e-> startNewGame());
		add(newTextButton);
		
		setVisible(true);
	}
	private void startNewGame() {
		wordPanel.removeAll();
		wordButtons.clear();
		userSentence.setLength(0);
		currentIndex=0;
		resultLabel.setText("문장을 완성하세요");
		
		String sentence = sentences.get(new Random().nextInt(sentences.size()));
		currentWords = sentence.split(" ");
		
		for(int i=0; i<currentWords.length; i++) {
			JButton wordButton = new JButton(currentWords[i]);
			wordButton.setBounds(randomX(), randomY(), 100, 30);
			wordButton.addActionListener(new WordClickListener());
			wordButtons.add(wordButton);
			wordPanel.add(wordButton);
		}
		wordPanel.repaint();
		wordPanel.revalidate();
	}
	
	private int randomX() {
		return new Random().nextInt(500);
	}
	private int randomY() {
		return new Random().nextInt(300);
	}
	
	private class WordClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			String word = clicked.getText();
			
			if(word.equals(currentWords[currentIndex])) {
				userSentence.append(word).append(" ");
				resultLabel.setText(userSentence.toString().trim());
				clicked.setVisible(false);
				currentIndex++;
				
				if(currentIndex == currentWords.length) {
					JOptionPane.showMessageDialog(null, "성공!");
				}
			}else {
				JOptionPane.showMessageDialog(null,"실패");
				startNewGame();
			}
		}
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new Exam_10());
	}

}





























