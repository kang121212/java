/*
 * 실습문제 7
 * 숫자를 입력받아 3~5는 "따뜻한 봄", 6~8은 "바다가 즐거운 여름" 9~11은 "낙업이 지는 아름다운 가을" 12,0,1의 경우
 * "눈 내리는 하얀 겨울"을, 그 외 숫자 (문자를 입력하여 발생하는 오류를 처리하는 것은 3장 7절 예외에서 다룹니다)를 입력한 경우 
 * "1~12만 입력하세요"를 출력하는 프로그램을 작성하라.
 * 2)switch문을 이용하여 프로그램을 작성하라
 */
package basic;

import java.util.Scanner;

public class Project_2_12 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int month;
		
		System.out.print("월을 입력하세요 >>");
		month = scn.nextInt();
		
		switch(month) {
			case 3:
				System.out.println("따뜻한 봄");
				break;
			case 4:
				System.out.println("따뜻한 봄");
				break;
			case 5:
				System.out.println("따뜻한 봄");
				break;
			case 6:
				System.out.println("바다가 즐거운 여름");
				break;
			case 7:
				System.out.println("바다가 즐거운 여름");
				break;
			case 8:
				System.out.println("바다가 즐거운 여름");
				break;
			case 9:
				System.out.println("낙엽이 지는 아름다운 가을");
				break;
			case 10:
				System.out.println("낙엽이 지는 아름다운 가을");
				break;
			case 11:
				System.out.println("낙엽이 지는 아름다운 가을");
				break;
			case 12:
				System.out.println("눈 내리는 하얀 겨울");
				break;
			case 1:
				System.out.println("눈 내리는 하얀 겨울");
				break;
			case 2:
				System.out.println("눈 내리는 하얀 겨울");
				break;
			default:
				System.out.println("1~12만 입력하세요.");
		}
		
		scn.close();
	}
}
