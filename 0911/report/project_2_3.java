package basic;

import java.util.Scanner;

public class project_2_3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int birth, year, month, date;
		System.out.print("생년월일을 입력하세요 >> ");
		birth = scn.nextInt();
		
		year = birth/10000;
		month = (birth%10000)/100;
		date = (birth%10000)%100;
		
		System.out.println(year+"년 "+month+"월 "+date+"일");
		scn.close();
	}
}
