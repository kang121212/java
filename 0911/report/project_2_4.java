package basic;

import java.util.Scanner;

public class project_2_4 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int dduek, kim, jjol, total;
		
		System.out.println("*** 자바 분식입니다. 주문하면 금액을 알려드립니다.***");
		System.out.print("떡볶이 몇 인분 >>");
		dduek = scn.nextInt()*2000;
		System.out.print("김말이 몇 인분 >>");
		kim = scn.nextInt()*1000;
		System.out.print("쫄면 몇 인분 >>");
		jjol = scn.nextInt()*3000;
		
		total = dduek+kim+jjol;
		System.out.println("전체 금액은 "+total+"원 입니다.");
		
		scn.close();
	}
}
