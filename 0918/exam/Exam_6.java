package exam_0918;

import java.util.Scanner;

public class Exam_6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n [] = new int[10];
		System.out.print("양의 정수 10개 입력 >> ");
		for(int i =0; i<10; i++) {
			n[i] = scn.nextInt();
		}
		System.out.print("자리수의 합이 9인 것은 ... ");
		for(int i =0; i<10; i++) {
			int a=n[i]/100;
			int b=(n[i]%100)/10;
			int c=((n[i]%100)%10);
			if((a+b+c)==9) {
				System.out.print(n[i]+" ");
			}
		}
		scn.close();
	}
}
