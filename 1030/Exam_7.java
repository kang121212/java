/* 
 * 실습문제 7
 * 실행 예시와 같이 년도를 입력받아 달력을 출력하는 프로그램을 작성하라.
 * 이때 날짜와 관련된 클래스는 Calendar 클래스만 활용하라.
 */

package appl;

import java.util.Calendar;
import java.util.Scanner;

public class Exam_7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.print("년도 입력(-1이면 종료) >> ");
			int year = scn.nextInt();
			if(year == -1) break;
			
			for(int month = 0; month < 12; month++) {
				Calendar cal = Calendar.getInstance();
				cal.set(year,  month, 1);	//해당 월의 1일로 설정
				
				int startDay = cal.get(Calendar.DAY_OF_WEEK);//시작요일
				int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
				System.out.println("["+ (month+1) + "월]");
				System.out.println(" 일  월  화  수  목  금  토");
				for(int i=1; i<startDay; i++) {
					System.out.print("   ");
				}
				for(int day = 1; day <= lastDay; day++) {
					System.out.printf("%3d",day);
					if((startDay + day -1)%7 == 0) {
						System.out.println();
					}
				}
				System.out.println();
			}
		}
		scn.close();
	}
}
