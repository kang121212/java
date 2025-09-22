package exam_0918;

import java.util.Scanner;

public class Exam_7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n [] = new int[10];
		int sum=0;
		System.out.print("랜덤한 정수들 >> ");
		for(int i =0; i<10; i++) {
			n[i] = (int)(Math.random()*9) + 11;
			System.out.print(n[i]+" ");
			sum += n[i];
		}
		System.out.print("평균은 "+ (double)sum/10);
		
		scn.close();
	}
}
