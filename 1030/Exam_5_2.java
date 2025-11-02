/*
 * 실습문제 5
 * 실행 사례와 같이 개수가 정해지지 않은 여러 과목의 학점을 빈 칸으로 분리하여 입력받고,
 * A는 100점, B는 90점, C는 80점, D는 70점, F는 0점으로 계산하여 평균을 출력하는 프로그램을 작성하라.
 * 대소문자는 구분하지 않는다.
 * (2) 문자열 분리를 위해 StringTokenizer 클래스를 이용하라.
 */

package appl;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Exam_5_2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("여러 과목의 학점을 빈칸으로 분리 입력 >>");
		String line = scn.nextLine();//한줄 입력받기
		
		StringTokenizer st = new StringTokenizer(line, " ");//빈칸 기준으로 분리
		
		int sum = 0;
		int count = 0;
		
		while(st.hasMoreTokens()) {
			String grade = st.nextToken().toUpperCase();//대소문자 구분 없이 처리
			int score = 0;
			
			switch(grade) {
				case "A":score = 100; break;
				case "B": score = 90; break;
				case "C": score = 80; break;
				case "D": score = 70; break;
				case "F": score = 0; break;
				default:
					System.out.println("잘못된 학점 입력 : "+grade);
					continue;//무효한 학점은 건너뜀
			}
			sum += score;
			count++;
		}
		if(count>0) {
			double average = (double) sum/count;
			System.out.print("평균은 "+ average+"점입니다.");
		} else {
			System.out.println("유효한 학점이 없습니다.");
		}
		
		
		scn.close();
	}
}
