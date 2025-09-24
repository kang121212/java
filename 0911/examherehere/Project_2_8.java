/*
 * 실습문제 10
 * 2차원 평면에서 사각형은 두 점으로 표현할 수 있다. 사용자로부터 사각형을 구성하는 두 점 (x1,y1),(x2,y2) 을 입력받고 이 사각형이
 * (10,10)(200,300)의 사각형에 완전히 포함되면 "포함된다." 아니면 "포함되지 않는다."를 출력하는 프로그램을 작성하라.
 */
package basic;

import java.util.Scanner;

public class Project_2_8 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x1,y1, x2,y2;
		int rx1 = 10;
		int ry1 = 10;
		int rx2 = 200;
		int ry2 = 300;
		
		System.out.print("점(x1, y1), (x2, y2)의 좌표 입력 >>");
		x1 = scn.nextInt();
		y1 = scn.nextInt();
		x2 = scn.nextInt();
		y2 = scn.nextInt();
		
		if(((x1>=rx1 && x1<=rx2) && (x2>=rx1 && x2<=rx2)) && ((y1>=ry1 && y1<=ry2) && (y2>=ry1 && y2<=ry2)))
			System.out.println("(" + x1 + ", " + y1 + ") ("+ x2 + ", "+y2 +")는 (10,10) (200,300)사각형에 포함된다.");
		else
			System.out.println("(" + x1 + ", " + y1 + ") ("+ x2 + ", "+y2 +")는 (10,10) (200,300)사각형에 포함되지 않는다.");
		
		scn.close();
		
	}
}
