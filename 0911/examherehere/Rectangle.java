package basic;

import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		/*
		 * 사각형의 height와 width를 입력받아 면적을 출력하는 프로그램 작성
		 */
		Scanner scn = new Scanner(System.in);
		
		double height, width;
		System.out.println("사각형의 height와 width를 입력하세요");
		height = scn.nextDouble();
		width = scn.nextDouble();
		
		System.out.println("사각형의 면적 = " + height*width);
		
		scn.close();
	}
}
