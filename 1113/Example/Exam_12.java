/*
 * 실습문제 12
 * 2명이 하는 카드 찾기 게임을 작성하라. 12장의 카드에 2장씩 같은 수(1~6까지)가 적혀있고
 * 같은 수를 가진 2장의 카드를 찾아내는 게임이다. 실행 사례와 같이 12장의 카드의 뒷면을 출력하라. 사용자가 
 * 마우스로 카드를 클릭하면 카드의 앞면이 출력된다. 같은 수가 적힌 카드를 연속하여 2장 선택하였을때 
 * 점수를 얻고 2장의 카드들이 제거된다. 2번째 카드가 틀렸으면 앞서 선택한 카드를 뒤집어 놓고 두번째 카드의 번호를 화면 아래에 출력하여 사용자가 알게 한다.
 * 2명이 번갈아 시도하여 많이 맞춘 사람이 이긴다. 카드 맞추기가 완료되면 처음부터 게임이 시작된다.
 */
package Exam;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Exam_12 extends JFrame {
    private JButton[] cards = new JButton[12];
    private int[] cardValues = new int[12];
    private boolean[] matched = new boolean[12];

    private int firstIndex = -1;
    private int secondIndex = -1;

    private int currentPlayer = 1;
    private int[] scores = new int[2];

    private JLabel statusLabel;

    public Exam_12() {
        setTitle("카드 맞추기 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        JPanel cardPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 카드 생성
        for (int i = 0; i < 12; i++) {
            JButton btn = new JButton("?");
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.setBackground(Color.LIGHT_GRAY);
            final int index = i;
            btn.addActionListener(e -> handleCardClick(index));
            cards[i] = btn;
            cardPanel.add(btn);
        }

        add(cardPanel, BorderLayout.CENTER);

        // 상태 표시 레이블
        statusLabel = new JLabel("Player 1 차례입니다.", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(statusLabel, BorderLayout.SOUTH);

        initGame();
        setVisible(true);
    }

    private void initGame() {
        // 카드 값 초기화 (1~6 두 개씩)
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            values.add(i);
            values.add(i);
        }
        Collections.shuffle(values);
        for (int i = 0; i < 12; i++) {
            cardValues[i] = values.get(i);
            cards[i].setText("?");
            cards[i].setEnabled(true);
            matched[i] = false;
        }

        scores[0] = 0;
        scores[1] = 0;
        currentPlayer = 1;
        firstIndex = -1;
        secondIndex = -1;
        statusLabel.setText("Player 1 차례입니다.");
    }

    private void handleCardClick(int index) {
        if (matched[index] || index == firstIndex) return;

        cards[index].setText(String.valueOf(cardValues[index]));

        if (firstIndex == -1) {
            firstIndex = index;
        } else {
            secondIndex = index;
            Timer timer = new Timer(1000, e -> checkMatch());
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void checkMatch() {
    	if (firstIndex == -1 || secondIndex == -1) return; // 잘못된 상태 방지

        if (cardValues[firstIndex] == cardValues[secondIndex]) {
            matched[firstIndex] = true;
            matched[secondIndex] = true;
            cards[firstIndex].setEnabled(false);
            cards[secondIndex].setEnabled(false);
            scores[currentPlayer - 1]++;
            statusLabel.setText("Player " + currentPlayer + " 정답! 점수: " + scores[0] + " - " + scores[1]);
        } else {
            cards[firstIndex].setText("?");
            cards[secondIndex].setText("?");
            statusLabel.setText("Player " + currentPlayer + " 실패! 선택한 숫자: " + cardValues[secondIndex]);
            currentPlayer = 3 - currentPlayer; // 1 <-> 2
        }

        firstIndex = -1;
        secondIndex = -1;

        if (isGameOver()) {
            String winner;
            if (scores[0] > scores[1]) winner = "Player 1 승리!";
            else if (scores[1] > scores[0]) winner = "Player 2 승리!";
            else winner = "무승부!";
            JOptionPane.showMessageDialog(this, "게임 종료!\n" + winner);
            initGame();
        }
    }

    private boolean isGameOver() {
        for (boolean b : matched) {
            if (!b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exam_12());
    }
}