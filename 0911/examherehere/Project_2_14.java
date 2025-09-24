/*
 * 실습문제 12
 * 자동차 제어 장치에는 자동차의 상태를 나타내는 정수형 변수가 있다.
 * 이 변수의 각 비트는 다음과 같이 자동차의 상태를 나타낸다고 하다.
 * 예를들어, 자동차의 상태를 나타내는 정수형 변수의 값이 139라면 이 값은 이진수로 10001011이므로
 * 비트 7의 값이 1이고, 비트 6의 값이 0이며, 비트 0~5의 값이 10진수로 11이다.
 * 그러므로 자동차는 달리는 상태이고, 에어컨은 거진 상태이며 차내 온도는 11도 이다.
 * 자동차 상태를 나타내는 정수를 입력받아 자동차의 상태를 화면에 출력하는 프로그램을 작성하라.
 */
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
