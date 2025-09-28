/*
 * 실습문제 3
 * Grade는 한 학생의 점수를 나타내는 클래스이다. 
 * 이름과 3개의 과목 점수를 각각 입력받아 Grade 객체를 생성하고 성적 평균을 
 * 출력하는 main()과 실행 예시는 다음과 같다.
 * main()을 포함하는 Grade 클래스를 작성하라.
 */
package Exam_0925;

import java.util.Scanner;

class Grade{
	public String name ;
	public int java;
	public int web;
	public int os;
	
	public Grade(String name, int java, int web, int os) {
		this.name = name;
		this.java = java;
		this.web = web;
		this.os = os;
	}
	
	public String getName() {
		return name;
	}
	public double getAverage() {
		return (java+web+os)/3.0;
	}
}


public class Exam_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력 >> ");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner.nextInt();
		Grade st = new Grade(name, java, web, os);	//한 명의 점수 객체 생성
		System.out.print(st.getName() + "의 평균은 "+st.getAverage());
		scanner.close();
	}
}
