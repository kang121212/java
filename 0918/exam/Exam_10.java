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
