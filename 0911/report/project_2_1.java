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
