/*
 * 실습문제 9
 * 2차원 평면에서 사각형은 두 점으로 표현할 수 있다. (10,10)과 (200,200)의 두 점으로 이루어진 사각형이 있을때,
 * 정수 x와 y값을 입력받고 점 (x,y)가 이 사각형 안에 있는지 사각형 선 상에 있는지, 사각형 외부에 있는지를
 * 판별하는 프로그램을 작성하라. 다음은 서로 다른 3가지 경우에 대한 실행 사례이다.
 */
package basic;

import java.util.Scanner;

public class Project_2_7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x1= 10;
		int x2= 200;
		int y1= 10;
		int y2= 300;
		int x,y;
		
		System.out.print("점(x, y)의 좌표 입력 >>");
		x = scn.nextInt();
		y = scn.nextInt();
		
		if((x>x1 && x<x2) && (y>y1 && y<y2))
			System.out.println("(" + x + ", " + y + ")는 사각형 안에 있습니다.");
		else if(((x==x1 || x==x2) && (y>=y1 && y<=y2)) || ((y==y1 || y==y2) && (x>=x1 && x<=x2)))
			System.out.println("(" + x + ", " + y + ")는 사각형 선상에 있습니다.");
		else
			System.out.println("(" + x + ", " + y + ")는 사각형 밖에 있습니다.");
		
			
		
		
		scn.close();
		
	}
}
