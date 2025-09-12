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
