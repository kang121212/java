/* 연습문제 12
 * 다음과 같은 DIctionary 클래스가 있다. 실행 결과와 같이 작동하도록 Dictionary 클래스에 kor2Eng()메소드를 작성하고
 * 실해 ㅇ결과와 가이 출력하는 DicApp 클래스를 작성하라.
 */
package Exam_0925;

import java.util.Scanner;

class Dictionary{
	private static String [] kor = {"사랑","아기","돈","미래","희망"};
	private static String [] eng = {"love","baby","money","future","hope"};
	public static String kor2Eng(String word) {
		for(int i=0; i<kor.length; i++) {
			if(kor[i].equals(word))
				return eng[i];
		}
		return "사전에 없다.";
	}
}

public class Exam_12 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("한영 단어 검색 프로그램입니다.");
		while(true) {
			System.out.print("한글 단어 >> ");
			String word = scn.next();
			if(word.equals("그만"))
				break;
			System.out.println(word+"은 "+Dictionary.kor2Eng(word));
		}
		
		scn.close();
	}
}
