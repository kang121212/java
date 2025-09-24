/*
 * 실습문제 3
 * 스캐너를 이용하여 양의 정수를 입력받고 다음과 같이 *를 출력하는 프로그램을 작성하라.
 * 양의 정수가 입력될 때까지 계속 입력을 받로고 하라. 다음 실행 사례는 5를 입력받은 경우이다.
 */
package exam_0918;

import java.util.Scanner;

public class Exam_3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n ;
		System.out.print("양의 정수 입력 >> ");
		n = scn.nextInt();
		while(n<=0) {
			System.out.print("양의 정수 입력 >> ");
			n = scn.nextInt();
		}
		for(int i=n; i>0; i--) {
			for(int a = 1; a<=i; a++) {
				System.out.print("*");
				n--;
			}
			System.out.println(" ");
		}
		scn.close();
	}
}
