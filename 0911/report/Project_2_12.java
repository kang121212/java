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
