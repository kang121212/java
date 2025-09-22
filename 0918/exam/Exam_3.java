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
