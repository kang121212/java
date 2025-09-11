package basic;

import java.util.Scanner;

public class Project_2_6_2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		float a, b, c =0;
		boolean valid=true;
		
		System.out.print("연산 입력 >> ");
		a = scn.nextFloat();
		String op = scn.next();
		b = scn.nextFloat();
		
		switch(op) {
		case "더하기":
			c=a+b;
			break;
		case "빼기":
			c=a-b;
			break;
		case "곱하기":
			c=a*b;
			break;
		case "나누기":
			if(b==0) {
				System.out.println("0으로 나눌 수 없습니다.");
				valid = false;
			}else
				c = a/b;
			break;
			
		default:
			System.out.println("사칙연산이 아닙니다.");
			valid = false;
		}
		
		if(valid==true)
			System.out.println(a+" "+op+" "+b+"의 계산 결과는 "+c);
		
		scn.close();
	}
}
