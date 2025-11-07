/*
 * 실습문제 5
 * 항공사에서 고객의 마일리지를 관리하는 프로그램을 해시맵을 이용하여 작성하라.
 * 프로그램은 고객의 이름과 마일리지를 함께 저장하며, 마일리지는 누적 저장된다.
 */

package generic;

import java.util.HashMap;
import java.util.Scanner;

public class Exam_5 {
	public static void main(String[] args) {
		HashMap<String, Integer> mileageMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("고객 마일리지 입력 프로그램입니다.");
		System.out.println("고객 이름과 적립할 마일리지를 입력하세요");
		while(true) {
			System.out.print("고객 이름 : ");
			String name = scanner.nextLine();
			if(name.equals("그만"))
				break;
			System.out.print("적립 마일리지 : ");
			try {
				int mileage = Integer.parseInt(scanner.nextLine());
				mileageMap.put(name, mileageMap.getOrDefault(name,0)+mileage);
			} catch(NumberFormatException e) {
				System.out.println("숫자 형식의 마일리지를 입력해주세요.");
			}
		}
		System.out.println("\n고객별 누적 마일리지 현황: ");
		for(String customer : mileageMap.keySet())
			System.out.println(customer+" : " + mileageMap.get(customer)+" 마일");
		
		scanner.close();
	}
}
