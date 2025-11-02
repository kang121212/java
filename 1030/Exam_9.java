/*
 * 실습문제 9
 * 실행 예시와 같이 사용자로부터 문자열을 입력받아, 5*5 문자 배열에 단어를 내장시키는 프로그램을 작성하라.
 * 한 단어는 가로, 세로, 대각선 모두 배치 가능하지만 글자들이 연결되어야 한다. 
 * 배열 속의 빈 칸은 랜덤한 문자로 채워라.
 */

package appl;

import java.util.Random;
import java.util.Scanner;

public class Exam_9 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Random rand = new Random();
		
		char[][] board = new char[5][5];
		
		System.out.print("단어 >> ");
		String word = scn.nextLine().toUpperCase();//대문자로 변환
		
		int[][] directions = {
				{0,1},	//오른쪽
				{1,0},	//아래
				{1,1},	//오른쪽 아래 대각선
				{-1,1},
				{0,-1},
				{-1,0},
				{-1,-1},
				{1,-1}
		};
		
		boolean placed = false;
		
		while(!placed) {
			int dirIndex = rand.nextInt(directions.length);
			int dx = directions[dirIndex][0];
			int dy = directions[dirIndex][1];
			
			int x = rand.nextInt(5);
			int y = rand.nextInt(5);
			
			int endX = x+dx*(word.length()-1);
			int endY = y+dy*(word.length()-1);
			
			if(endX < 0 || endX >=5 || endY<0 || endY >= 5) continue;
			
			for(int i=0; i<word.length(); i++) {
				board[x+dx*i][y+dy*i] = word.charAt(i);
			}
			
			placed=true;
		}
		
		for(int i = 0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(board[i][j]=='\u0000') {
					board[i][j] = (char) ('A' + rand.nextInt(26));
				}
			}
		}
		System.out.println("\n문자 배열 : ");
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	scn.close();
	}
}
