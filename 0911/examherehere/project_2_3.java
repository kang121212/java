/*실습문제2
 * 사용자가 입력하는 8자리의 정수는 생일을 나타낸다. 예를들어 20010316은 2001년3월16일을 뜻한다. 
 * 스캐너 클래스의 nextInt() 메소드를 이용하여 8자리 정수를 입력받고 년도/월/일을 나누어 출력하라. 
 * 8자리 정수가 입력되지 않는 경우는 고려하지 않는다.
 * 
 */
package basic;

import java.util.Scanner;

public class project_2_3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int birth, year, month, date;
		System.out.print("생년월일을 입력하세요 >> ");
		birth = scn.nextInt();
		
		year = birth/10000;
		month = (birth%10000)/100;
		date = (birth%10000)%100;
		
		System.out.println(year+"년 "+month+"월 "+date+"일");
		scn.close();
	}
}
