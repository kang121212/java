package exam_0918;

import java.util.Scanner;

public class Exam_8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int sum=0;
		
		System.out.print("정수를 몇 개 저장하시겠습니까? >> ");
		int a = scn.nextInt();
		int n [] = new int[a];
		 
		
		for(int i =0; i<n.length; i++) {
			int b = (int)(Math.random()*99)+1;
			boolean duplicate = false;
			for(int c=0; c<i; c++) {
				if(b==n[c]) {
					duplicate = true;
					break;
				}
				if(duplicate == false)
					n[i]=b;
			}
		}
		System.out.print("랜덤한 정수들... >> ");
		for(int d=0; d<n.length; d++) {
			System.out.print(n[d]+" ");
			sum += n[d];
		}
		System.out.print("평균은 "+ (double)sum/n.length);
		scn.close();
	}
}
