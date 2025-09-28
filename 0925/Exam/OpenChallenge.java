/* 오픈 챌린지
 * n명이 참가하는 끝말잇기 게임을 만들어 보자, 처음 단어는 "아버지"이다. n명의 참가자들은 순서대로 자신의 단어를 입력하면 된다.
 * 끝말잇기에서 끝말이 틀린 경우 게임을 끝내고 게임에서 진 참가자를 화면에 출력한다. 프로그램에서는 시간 지연을 구현하지 않아도 된다. 
 * 그렇지만 참가자들이 스스로 시간을 재어 보는 것도 좋겠다. 이 문제의 핵심은 여러 개의 객체와 배열 사용을 연습하기 위한 것으로
 * main()을 포함하는 WordGameApp 클래스와 각 선수를 나타내는 Player 클래스를 작성하고, 실행 중에는 WordGameApp 객체 하나와 선수 숫자만큼의 
 * Player 객체를 생성하는데 있다. 문제에 충실하게 프로그램을 작성하여야 실력이 늘게 됨을 알기 바란다.
 */
package Exam_0925;

import java.util.Scanner;

class Player1 {
    private String name;
    private Scanner scn;

    public Player1(String name) {
        this.name = name;
        scn = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public String sayWord() {
        System.out.print(name + " >> ");
        return scn.next();
    }
}
class WordGameApp {
    private Player1[] players;
    private Scanner scn;

    public WordGameApp(int numPlayers) {
        scn = new Scanner(System.in);
        players = new Player1[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("참가자 이름 입력 >> ");
            String name = scn.next();
            players[i] = new Player1(name);
        }
    }

    public void run() {
        String prevWord = "아버지";
        System.out.println("시작 단어는 \"" + prevWord + "\"입니다.");

        int turn = 0;
        while (true) {
            Player1 current = players[turn % players.length];
            String newWord = current.sayWord();

            // 끝말잇기 규칙 확인
            char lastChar = prevWord.charAt(prevWord.length() - 1);
            char firstChar = newWord.charAt(0);

            if (lastChar != firstChar) {
                System.out.println(current.getName() + "이(가) 졌습니다.");
                break;
            }

            prevWord = newWord;
            turn++;
        }
    }
}
public class OpenChallenge {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("끝말잇기 게임을 시작합니다...");
		System.out.print("게임에 참가하는 인원은 몇명입니까 >> ");
		int number = scn.nextInt();
		WordGameApp game = new WordGameApp(number);
		game.run();
		scn.close();
	}
}
