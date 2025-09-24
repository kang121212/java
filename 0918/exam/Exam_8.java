/*
 * 실습문제 8
 * 몇 개의 정수를 저장할 것인지 개수를 입력받고, 그 만큼의 배열을 생성하라. 그리고 배열에 1~100 범위의 랜덤한 정수를 저장한 후, 
 * 정수들과 평균을 출력하라. 단 같은 정수가 저장되지 않게 하라.
 */
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
