/*
 * 실습문제 11
 * n명이 함께하는 갬블링 게임을 만들어 보자. 실행 예시와 같이 게임에 참여하는 선수 수를 입력받고
 * 각 선수의 이름을 입력 받는다. 그리고 순서대로 각 선수가 <Enter> 키를 입력하면 1~3 사이의 
 * 랜덤한 정수 3개를 출력하고 모두 일치하면 승자가 된다. 각 선수는 Player 클래스로 구현하고 게임 전체는
 * GameblingGame 클래스로 구현하라.
 */

package appl;

import java.util.Random;
import java.util.Scanner;

class Player{
	private String name;
	private Random rand = new Random();
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public boolean play() {
		int[] nums = new int[3];
		for(int i=0; i<3; i++) {
			nums[i]=rand.nextInt(3)+1;
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		return nums[0] == nums[1] && nums[1] == nums[2];
	}
}

class GamblingGame{
	private Player[] players;
	private Scanner scn = new Scanner(System.in);
	public GamblingGame() {
		System.out.print("갬블링 게임에 참여할 선수 숫자 >> ");
		int n = scn.nextInt();
		scn.nextLine();
		
		players = new Player[n];
		for(int i=0; i<n; i++) {
			System.out.print("참가자 이름 입력 >> ");
			String name = scn.nextLine();
			players[i] = new Player(name);
		}
	}
	public void run() {
		System.out.println("게임 시작! <Enter>키를 누르세요.");
		
		while (true) {
			for(Player p : players) {
				System.out.print(p.getName()+" >> ");
				scn.nextLine();
				if(p.play()) {
					System.out.println(p.getName() + "님이 승리");
					return;
				} else {
					System.out.println("아쉽네요");
				}
			}
		}
	}
}

public class Exam_11 {
	public static void main(String[] args) {
		GamblingGame game = new GamblingGame();
		game.run();
	}
}
