/* 연습문제 9
 * 숨겨진 숫자에 가장 가까운 수를 제시하는 사람이 이기는 예측게임을 작성해보자.
 * 1~100 범위의 정수를 랜덤하게 1개 생성하고, 게임에 참여한 선수들에게 수를 맞추게 한 후
 * 숨겨진 답에 가장 가까운 선수가 승기하며 1점을 부여한다.
 * 게임이 여러 번 반복되며 쌓인 점수가 많은 사람이 최종 승자가 된다. 게임에 참여하는 사람을 Player 클래스로 만들고
 * 이곳에 선수 이름과 누적 점수를 저장한다. main() 을 포함하는 게임 프로그램의 클래스는 GuessGame으로 하며 실행 예시는 다음과 같다.
 */
package Exam_0925;

import java.util.Scanner;
import java.util.Random;

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }
}

public class Exam_9 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("** 예측 게임을 시작합니다 ***");
        System.out.print("게임에 참여할 선수 수 >> ");
        int pnumber = scn.nextInt();
        scn.nextLine(); // 버퍼 비우기

        Player[] players = new Player[pnumber];
        for (int i = 0; i < pnumber; i++) {
            System.out.print("선수 이름 입력 >> ");
            String name = scn.nextLine();
            players[i] = new Player(name);
        }

        int round = 1;
        while (true) {
            System.out.println("\n[" + round + "라운드 시작]");
            int hidden = rand.nextInt(100) + 1;
            int[] guesses = new int[pnumber];

            for (int i = 0; i < pnumber; i++) {
                System.out.print(players[i].getName() + "의 예측 숫자 (1~100) >> ");
                guesses[i] = scn.nextInt();
            }
            scn.nextLine(); // 숫자 입력 후 버퍼 비우기

            // 가장 가까운 사람 찾기
            int minDiff = Integer.MAX_VALUE;
            int winnerIndex = -1;
            for (int i = 0; i < pnumber; i++) {
                int diff = Math.abs(hidden - guesses[i]);
                if (diff < minDiff) {
                    minDiff = diff;
                    winnerIndex = i;
                }
            }

            System.out.println("숨겨진 숫자: " + hidden);
            System.out.println("이번 라운드 승자: " + players[winnerIndex].getName());
            players[winnerIndex].addScore();

            System.out.print("계속하려면 'yes'를 입력하세요 >> ");
            String input = scn.nextLine();
            if (!input.equalsIgnoreCase("yes")) {
                System.out.println("\n게임을 종료합니다.");
                printFinalScores(players);
                break;
            }
            round++;
        }

        scn.close();
    }

    private static void printFinalScores(Player[] players) {
        System.out.println("\n=== 최종 점수 ===");
        int maxScore = -1;
        String finalWinner = "";
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getScore() + "점");
            if (p.getScore() > maxScore) {
                maxScore = p.getScore();
                finalWinner = p.getName();
            }
        }
        System.out.println("최종 승자: " + finalWinner);
    }
}