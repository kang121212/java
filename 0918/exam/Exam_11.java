/*
 * 실습문제 11
 * 구구단 퀴즈의 답을 검사하는 프로그램을 작성하라. 
 * 랜덤하게 구구단을 묻고 사용자의 답을 입력받아 정답인지 판단한다. 3번 틀리면 종료한다.
 */
package exam_0918;

import java.util.Scanner;

public class Exam_11 {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int wrong=0;
		
		System.out.println("****** 구구단을 맞추는 퀴즈입니다. *******");
		while(wrong<3) {
			int a = (int)(Math.random()*9+1);
			int b = (int)(Math.random()*9+1);
			System.out.print(a+"*"+b+"=");
			int answer = scn.nextInt();
			if(answer==(a*b)) 
				System.out.println("정답입니다. 잘했습니다.");
			if(answer!=(a*b)) {
				wrong++;
				System.out.println(wrong+"번 틀렸습니다. 분발하세요.");
			}
		}
		System.out.println("3번 틀렸습니다. 퀴즈 종료합니다.");
		scn.close();
	}
}
