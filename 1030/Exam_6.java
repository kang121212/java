/*
 * 실습문제 6
 * 문자열을 입력받아 실행 예시와 같이 한 글자씩 회전시키는 프로그램을 작성하라.
 * I love Java
 *  love JavaI
 * love JavaI 
 *  JavaI love
 */

package appl;

import java.util.Scanner;

public class Exam_6 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
		String line = scn.nextLine();
		
		int len = line.length();
		
		for(int i=0; i<len; i++) {
			String rotated = line.substring(i) + line.substring(0,i);
			System.out.println(rotated);
		}
		
		scn.close();
	}
}
