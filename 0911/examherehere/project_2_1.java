/*
 * 오픈 챌린지
 * 가위바위보게임
 * 두 사람이 하는 가위바위보 게임을 만들어 보자. 두 사람의 이름은 '철수'와 '영희'이다. 먼저 '철수>>'를 출력하고
 * 가위, 바위, 보 중 하나를 문자열로 입력받는다.
 * 그리고 영의>>를 출력하고 마찬가지로 입력받는다. 입력받은 문자열을 비교하여 누가 이겼는지 판별하여 승자를 출력한다.
 * 
 */
package basic;

import java.util.Scanner;

public class project_2_1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String cheol, young;
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		System.out.print("철수 >>");
		cheol = scn.next();
		System.out.print("영희 >>");
		young = scn.next();
		if(cheol.equals(young)) {
			System.out.println("비겼습니다.");
		} else if((cheol.equals("가위") && young.equals("바위")) || (cheol.equals("바위") && young.equals("보")) || (cheol.equals("보") && young.equals("가위"))) {
			System.out.println("영희가 이겼습니다.");
		} else {
			System.out.println("철수가 이겼습니다.");
		}
		
		scn.close();
	}
}
