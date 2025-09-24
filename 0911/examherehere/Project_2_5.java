/*
 * 실습문제 4
 * 여행경비를 계산하는 프로그램을 작성한다.
 * 방 하나에는 2명까지 투숙 가능하며 1명만 투숙해도 1방의 비용을 지불한다.
 */
package basic;

import java.util.Scanner;

public class Project_2_5 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int plane, accom, rooms, total;
		
		System.out.print("여행지 >>");
		String place = scn.nextLine();
		System.out.print("인원 수 >>");
		int people = scn.nextInt();
		System.out.print("숙박일 >>");
		int days = scn.nextInt();
		System.out.println("1인당 항공료 >> ");
		plane = scn.nextInt();
		System.out.println("1방 숙박비 >> ");
		accom = scn.nextInt();
		
		if(people%2 ==0)
			rooms=people/2;
		else
			rooms=people/2+1;
		total = (plane*people)+(accom*rooms);
		
		System.out.println(people+"명의 "+place+" "+days+"박 "+(days+1)+"일 여행에는 "
				+ "방이 "+rooms+"개 필요하며 경비는 "+total+"원입니다.");
		
		scn.close();
	}
}
