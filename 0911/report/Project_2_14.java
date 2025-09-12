package basic;

import java.util.Scanner;

public class Project_2_14 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("자동차 상태 입력 >> ");
		int input = scn.nextInt();
		
		String str = Integer.toBinaryString(input);
		int status = Integer.parseInt(str,2);
		//위에꺼 안해도 된다. int정수형은 자동으로 2진수로 인식;;;
		
		if((status & 0b10000000) != 0)
			System.out.print("자동차는 달리는 상태이고 ");
		else
			System.out.print("자동차는 정지 상태이고 ");
		
		if((status & 0b01000000) != 0)
			System.out.print("에어컨이 켜진 상태이고 ");
		else
			System.out.print("에어컨이 꺼진 상태이고 ");
		
		int temp = status & 0b00011111;
		System.out.print("온도는 "+temp+"도 이다.");
		
		scn.close();
	}
}
