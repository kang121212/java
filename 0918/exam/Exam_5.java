/*
 * 실습문제 5
 * 양의 정수 10개를 입력받아 일차원 배열에 저장하라. 
 * 그리고 배열에 저장된 정수 중 3의 배수만 출력하는 프로그램을 작성하라.
 */
package exam_0918;

import java.util.Scanner;

public class Exam_5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n [] = new int[10];
		System.out.print("양의 정수 10개 입력 >> ");
		for(int i =0; i<10; i++) {
			n[i] = scn.nextInt();
		}
		System.out.print("3의 배수는 ... ");
		for(int i =0; i<10; i++) {
			if(n[i]%3==0) {
				System.out.print(n[i]+" ");
			}
		}
		scn.close();
	}
}
