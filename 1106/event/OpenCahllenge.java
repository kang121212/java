/*
 * 오픈 챌린지
 * 어릴 적 구슬치기를 하던 생각이 난다. 구슬들을 주먹으로 쥐고 홀인지 짝인지 맞추는 게임이다.
 * 이 게임을 실행 예시와 같이 스윙으로 작성하라. 프로그램이 실행되어 '?'가 출력된 박스에 1에서 10 사이의
 * 정수를 숨기면, 사용자가 이 정수가 홀인지 짝인지 맞추는 게임이다.
 * 가운데에 네보박스에 ?가 있고 네모박스 밑에 무엇일까요? / 홀! 맞았어요. / 홀! 아쉽군요./ 홀이나 짝 선택!
 * 이라고 표시하자
 * 그 밑에는 네모박스를 4개 배치하여 홀, 짝 ,확인 다시 를 배치한다.
 * 
 */

package Chapter_10;

import javax.swing.*;
import java.awt.*;

import java.util.Random;

public class OpenCahllenge {
    public static void main(String[] args) {
        JFrame frame = new JFrame("구슬치기 게임");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 중앙 상단: '?' 표시 박스
        JLabel questionBox = new JLabel("?", SwingConstants.CENTER);
        questionBox.setFont(new Font("Serif", Font.BOLD, 40));
        questionBox.setOpaque(true);
        questionBox.setBackground(Color.LIGHT_GRAY);
        questionBox.setPreferredSize(new Dimension(100, 100));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(questionBox, BorderLayout.CENTER);

        // 중앙 하단: 결과 메시지
        JLabel messageLabel = new JLabel("홀이나 짝 선택!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        centerPanel.add(messageLabel, BorderLayout.SOUTH);

        frame.add(centerPanel, BorderLayout.CENTER);

        // 하단 버튼들
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        JButton oddBtn = new JButton("홀");
        JButton evenBtn = new JButton("짝");
        JButton checkBtn = new JButton("확인");
        JButton resetBtn = new JButton("다시");

        buttonPanel.add(oddBtn);
        buttonPanel.add(evenBtn);
        buttonPanel.add(checkBtn);
        buttonPanel.add(resetBtn);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // 게임 상태 변수
        final int[] hiddenNumber = {new Random().nextInt(10) + 1};
        final String[] userChoice = {null};

        // 버튼 이벤트 처리
        oddBtn.addActionListener(e -> {
            userChoice[0] = "홀";
            messageLabel.setText("무엇일까요?");
        });

        evenBtn.addActionListener(e -> {
            userChoice[0] = "짝";
            messageLabel.setText("무엇일까요?");
        });

        checkBtn.addActionListener(e -> {
            if (userChoice[0] == null) {
                messageLabel.setText("홀이나 짝 선택!");
                return;
            }
            questionBox.setText(String.valueOf(hiddenNumber[0]));
            boolean isEven = hiddenNumber[0] % 2 == 0;
            if ((isEven && userChoice[0].equals("짝")) || (!isEven && userChoice[0].equals("홀"))) {
                messageLabel.setText(userChoice[0] + "! 맞았어요.");
            } else {
                messageLabel.setText(userChoice[0] + "! 아쉽군요.");
            }
        });

        resetBtn.addActionListener(e -> {
            hiddenNumber[0] = new Random().nextInt(10) + 1;
            questionBox.setText("?");
            userChoice[0] = null;
            messageLabel.setText("홀이나 짝 선택!");
        });

        frame.setVisible(true);
    }
}