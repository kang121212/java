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
