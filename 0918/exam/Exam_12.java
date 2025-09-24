/*
 * 실습문제 12
 * 사용자로부터 "남" 혹은 "여"를 입력받아, 남자 또는 여자의 이름을 작명하는 프로그램을 작성하라. 
 * 다음 실행 예시와 같이 "그만"을 입력하면 프로그램은 종료된다.
 */
package exam_0918;

import java.util.Scanner;

public class Exam_12 {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String boyMiddleList [] = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
		String boyLastList [] = {"태","진", "광","혁","우","철","빈","준","구","호","석"};
		String girlMiddleList [] = {"은","원","경","수","현","예","여","송","서","채","하"};
		String girlLastList [] = {"진","연","경","서","리","숙","미","원","린","희","수"};
		
		String boyLastName;
		String girlLastName;
		String sex;
		String stop = "계속해";
		
		System.out.println("*** 작명 프로그램이 실행됩니다. ****");
		while(stop.equals("계속해")) {
			System.out.print("남/여 선택 >> ");
			sex = scn.next();
			
			if(sex.equals("남")) {
				System.out.print("성 입력 >> ");
				boyLastName = scn.next();
				int index1 = (int)(Math.random()*boyMiddleList.length);
				String middle = boyMiddleList[index1];
				int index2 = (int)(Math.random()*boyLastList.length);
				String last = boyLastList[index2];
				
				System.out.println("추천 이름 >> "+boyLastName+middle+last);
			}
			else if(sex.equals("여")) {
				System.out.print("성 입력 >> ");
				girlLastName = scn.next();
				int index1 = (int)(Math.random()*girlMiddleList.length);
				String middle = girlMiddleList[index1];
				int index2 = (int)(Math.random()*girlLastList.length);
				String last = girlLastList[index2];
				
				System.out.println("추천 이름 >> "+girlLastName+middle+last);
			}
			else if(sex.equals("그만"))
				break;
			
			else 
				System.out.println("남/여/그만 중에서 선택하세요!!");
			
		}
		scn.close();
	}
}
