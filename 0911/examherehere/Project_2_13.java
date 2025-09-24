/*
 * 실습문제 11
 * 임베디드 컴퓨터에서는 변수의 각 비트를 장치의 상태를 나타내기 위해 사용한다.
 * 예를 들어 냉장고의 상태르 ㄹ나타내기 위해 8비트 정수 중 하위 4비트가 다음과 같이 사용된다고 하면,
 * 이 때 다음 실행 예시와 같이 냉장고의 상태를 나타내는 8비트를 입력받고 하위 4비트를 분석하여 
 * 냉장고의 상태를 출력하는 프로그램을 작성하라.
 */
package basic;

import java.util.Scanner;

public class Project_2_13 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("냉장고 상태 입력 >> ");
		String str = scn.next();
		
		byte status = Byte.parseByte(str, 2);
		
		if((status & 0b00000001) != 0)
			System.out.print("전원 켜져 있음. ");
		else
			System.out.print("전원 꺼져 있음. ");
		
		if((status & 0b00000010) != 0)
			System.out.print("문 닫혀 있음. ");
		else
			System.out.print("문 열려 있음. ");
		
		if((status & 0b00000100) != 0)
			System.out.print("전구 정상 작동. ");
		else
			System.out.print("전구 손상. ");
		
		if((status & 0b00001000) != 0)
			System.out.print("온도 3도 미만. ");
		else
			System.out.print("온도 3도 이상. ");
		
		scn.close();
	}
}
