/*
 * 실습문제 11
 * 실행 예시와 같이 작동하는 간단한 계산기를 만들어 보자. 사용자가 숫자(실수 포함)와 연산자 버튼을 클릭하여
 * 수식을 만든 후 "=" 버튼을 클릭하면 계산 결과에 나타난다. "C"는 입력된 수식을 지우는 버튼이고, "UN"은 수식
 * 에서 최근에 입력된 한 글자를 지우는 버튼이며 누를때마다 계속 지워진다. "BK"는 작동하지 않는 버튼이다.
 * 이 계산기는 1개의 연산으로 구성된 수식만 처리한다. 0으로 나누는 경우 "0으로 나눌 수 없음"을 계
 * 산결과에 출력하라.
 */
package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam_11 extends JFrame {
    private JTextField display;

    public Exam_11() {
        setTitle("간단 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // 결과 표시창
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "UN", "BK", ""
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            if (text.equals("")) {
                btn.setEnabled(false); // 빈칸 버튼
            } else if (text.equals("BK")) {
                btn.setEnabled(false); // 작동하지 않음
            } else {
                btn.addActionListener(new ButtonListener());
            }
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = ((JButton) e.getSource()).getText();

            switch (cmd) {
                case "C":
                    display.setText("");
                    break;
                case "UN":
                    String current = display.getText();
                    if (!current.isEmpty()) {
                        display.setText(current.substring(0, current.length() - 1));
                    }
                    break;
                case "=":
                    calculate();
                    break;
                default:
                    display.setText(display.getText() + cmd);
            }
        }
    }

    private void calculate() {
        String expr = display.getText();
        String result = "";

        try {
            if (expr.contains("+")) {
                String[] parts = expr.split("\\+");
                double res = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
                result = String.valueOf(res);
            } else if (expr.contains("-")) {
                String[] parts = expr.split("-");
                double res = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
                result = String.valueOf(res);
            } else if (expr.contains("*")) {
                String[] parts = expr.split("\\*");
                double res = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
                result = String.valueOf(res);
            } else if (expr.contains("/")) {
                String[] parts = expr.split("/");
                double divisor = Double.parseDouble(parts[1]);
                if (divisor == 0) {
                    result = "0으로 나눌 수 없음";
                } else {
                    double res = Double.parseDouble(parts[0]) / divisor;
                    result = String.valueOf(res);
                }
            } else {
                result = "잘못된 수식";
            }
        } catch (Exception ex) {
            result = "오류 발생";
        }

        display.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exam_11());
    }
}