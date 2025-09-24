/*
 * 실습문제 8
 * 실수(double)에 대한 사칙 연산을 수행하는 프로그램을 작성하라.
 * 연산은 더하기, 빼기, 곱하기, 나누기로 하고, 계산식은 2.3 더하기 3.6과 같이 빈칸으로 분리하여 입력한다.
 * 0으로 나누기가 입력되면 '으로 나눌 수 없습니다. 를 출력하고 연산 명령이 더하기, 빼기, 곱하기, 나누기가 아닌 경우 
 * 사칙연산이 아닙니다. 를 출력하고 종료한다.
 * 2) switch 문을 이용하여 프로그램을 작성하라.
 */
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
