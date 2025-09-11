package basic;

import java.util.Scanner;

public class project_2_2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int dollar, won;
		
		won = 1400;
		System.out.print("1$는 1400원 입니다. 달러를 입력하세요 >>");
		dollar = scn.nextInt();
		System.out.println("$" + dollar + "는 " + dollar*won + "원입니다.");
		
		scn.close();
	}
}
