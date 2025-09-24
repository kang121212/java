/*
 * 실습문제 9
 * 4*4 크기의 2차원 정수 배열을 생성하고, 0~255 범위의 정수 16개를 랜덤하게 생성하여 저장한 후,
 * 배열을 실행 사례와 같이 출력하라.
 */
package exam_0918;

import java.util.Scanner;

public class Exam_9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("4*4 배열에 랜덤한 값을 저장한 후 출력합니다");
		int n [][] = new int[4][4];
		
		for(int i =0; i<n.length; i++) {
			for(int a=0; a<n[i].length; a++) {
				int b = (int)(Math.random()*255)+1;
				n[i][a] = b;
				System.out.print(String.format("%3d", n[i][a])+"  ");
			}
			System.out.println(" ");
		}
		scn.close();
	}
}
