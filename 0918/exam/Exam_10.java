/*
 * 실습문제 10
 * 4*4 크기의 2차우너 정수 배열에 0~255 범위의 정수 16개를 랜덤하게 생성하여 초기화하고 출력하라.
 * 그리고 실행사례와 같이 임계값을 입력받고, 배열에 저장도니 정수가 임계값보다 크면 255, 작거나 같으면 0으로 배열을 수정한 후
 * 배열을 출력하라.
 */
package exam_0918;

import java.util.Scanner;

public class Exam_10 {

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
		System.out.print("임계값 입력 >> ");
		int limit = scn.nextInt();
		for(int i =0; i<n.length; i++) {
			for(int a=0; a<n[i].length; a++) {
				if(n[i][a]<=limit)
					n[i][a]= 0;
				else if(n[i][a]>limit)
					n[i][a]=255;
				System.out.print(String.format("%3d", n[i][a])+"  ");
			}
			System.out.println(" ");
		}
		
		
		
		
		
		scn.close();
	}
}
