/*
 * 실습문제 12
 * 점심 내기 게임을 만들어보자. 게임에 참여하는 선수 수는 고정되어 있지 않다. 
 * 프로그램은 처음에 선수들의 이름을 한 줄로 입력받는다. 입력되는 이름 개수가 곧 선수의 수이다. 그 다음
 * 각 선수로부터 1~10 사이에 좋아하는 정수를 하나 입력받는다. 그리고 사용자가 <enter>키를 입력하면
 * 프로그램은 15개의 정수를 랜덤하게 결정하고 이 중에서 좋아하는 정수가 가장 적게 등장한 선수 1명이 
 * 패자가 되어 점심을 산다. 패자가 1명이 아니면, 패자들 끼리 다시 게임이 진행되고 1명의 패자가 생길때까지
 * 계속된다. 실행 예시와 같이 실행되도록 프로그램을 작성하라. 선수는 Player 클래스로 구현하고
 * 게임은 NumberExpectationGame 클래스로 구현하라.
 */

package appl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Player1{
	private String name;
	private int favoriteNumber;
	private int count;
	public Player1(String name) {
		this.name = name;
	}
	public void setFavoriteNumber(int number) {
		this.favoriteNumber = number;
	}
	public int getFavoriteNumber() {
		return favoriteNumber;
	}
	public void resetCount() {
		count = 0;
	}
	public void incrementCount() {
		count++;
	}
	public int getCount() {
		return count;
	}
	public String getName() {
		return name;
	}
}

class NumberExpectationGame{
	private List<Player1> players;
	private Scanner scn;
	private Random rand;
	public NumberExpectationGame() {
		scn = new Scanner(System.in);
		rand = new Random();
		players = new ArrayList<>();
		
		System.out.print("선수 이름을 한 줄로 입력하세요 >> ");
		String line = scn.nextLine();
		String[] names = line.split(" ");
		
		for(String name : names) {
			players.add(new Player1(name));
		}
		for(Player1 p : players) {
			while(true) {
				System.out.print(p.getName() + "이가 좋아하는 숫자(1~10) >> ");
				int num = scn.nextInt();
				if(num>= 1 && num<=10) {
					p.setFavoriteNumber(num);
					break;
				}else {
					System.out.println("1~10 사이의 숫자만 입력하세요");
				}
			}
		}
		scn.nextLine();
	}
	
	public void run() {
		List<Player1> currentPlayers = new ArrayList<>(players);
		while(true) {
			System.out.print("<enter>를 누르면 게임 시작");
			scn.nextLine();
			int[] numbers = new int[15];
			System.out.print("랜덤 숫자 : ");
			for(int i=0; i<15; i++) {
				numbers[i] = rand.nextInt(10)+1;
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			for(Player1 p : currentPlayers) {
				p.resetCount();
			}
			for(int num : numbers) {
				for(Player1 p : currentPlayers) {
					if(p.getFavoriteNumber()==num) {
						p.incrementCount();
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(Player1 p : currentPlayers) {
				if(p.getCount() < min) {
					min = p.getCount();
				}
			}
			List<Player1> losers = new ArrayList<>();
			for(Player1 p : currentPlayers) {
				if(p.getCount() == min) {
					losers.add(p);
				}
			}
			
			if(losers.size()==1) {
				System.out.println("점심을 살 사람은 " + losers.get(0).getName());
				break;
			}else {
				System.out.print("패자 후보 : ");
				for(Player1 p : losers) {
					System.out.print(p.getName()+ " ");
				}
				System.out.println("패자가 1명이 될 때까지 다시 한다");
				currentPlayers = losers;
			}
		}
	}
}

public class Exam_12 {
	public static void main(String[] args) {
		NumberExpectationGame game = new NumberExpectationGame();
		game.run();
	}
}
