/*
 * 실습문제 6
 * 생일 케이크에 사용할 초를 준비하려고 한다. 빨간 초는 10살, 파란초는 5살, 파란초는 5살, 노란초는 1살을 나타낼때, 다음 실행사례를 
 * 참고하여 나이에 맞는 각 초의 개수를 계산하는 프로그램을 작성하라. 이 때, 전체 초의 개수가 최소가 되게 하라(빨간초,파란초,노란초
 * 순으로 개수를 계산하면 된다.) . 나이에 0이나 음수가 입력되면 "나이는 양수로만 입력하세요"를 출력하고 프로그램을 종료한다.
 */
package basic;

import java.util.Scanner;

public class Project_2_10 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int red, blue, yel, age;
		
		System.out.print("나이를 입력하세요>>");
		age = scn.nextInt();
			
		if(age>0) {
			red = age/10;
			blue = (age%10)/5;
			yel = (age%10)%5;
			int total = red+blue+yel;
			System.out.println("빨간초"+red+"개, 파란초 "+blue+"개, 노란초 "+yel+"개. 총 "+total+"개가 필요합니다.");
		}
		else 
			System.out.println("나이는 양수로만 입력하세요.");
		
		scn.close();
	}
}
