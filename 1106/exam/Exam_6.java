/*
 * 실습문제 6
 * HashMap<String, Integer>의 해시맵을 활용하여 실행 예시와 같이 동작하는
 * 계좌 관리 프로그램을 작성하라. 이 문제를 통해 해시맵에 원소 삽입, 조회, 수정 등 다양한
 * 연습이 가능하다. 입금:1, 출금:2, 조회:3, 전체조회:4, 종료:5
 */

package generic;

import java.util.HashMap;
import java.util.Scanner;

public class Exam_6 {
	public static void main(String[] args) {
		HashMap<String, Integer> accountMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("계좌 관리 프로그램입니다.");
		System.out.println("입금:1, 출금:2, 조회:3, 전체조회:4, 종료:5");
		while(true) {
			System.out.print("\n메뉴선택: ");
			int menu;
			try {
				menu = Integer.parseInt(scanner.nextLine());
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
				continue;
			}
			switch(menu) {
				case 1:
					System.out.print("고객이름 : ");
					String depositName = scanner.nextLine();
					System.out.print("입금 금액 : ");
					int depositAmount = Integer.parseInt(scanner.nextLine());
					accountMap.put(depositName, accountMap.getOrDefault(depositName, 0)+depositAmount);
					System.out.println(depositName+"님의 계좌에 "+depositAmount+"원이 입금되었습니다.");
					break;
					
				case 2:
					System.out.print("고객이름 : ");
					String withdrawName = scanner.nextLine();
					if(!accountMap.containsKey(withdrawName)) {
						System.out.println("해당 고객의 계좌가 존재하지 않습니다.");
						break;
					}
					System.out.print("출금 금액: ");
					int withdrawAmount = Integer.parseInt(scanner.nextLine());
					int currentBalance = accountMap.get(withdrawName);
					if(withdrawAmount > currentBalance)
						System.out.println("잔액이 부족합니다.");
					else {
						accountMap.put(withdrawName, currentBalance - withdrawAmount);
						System.out.println(withdrawName + "님의 계좌에서 "+withdrawAmount+"원이 출금되었습니다.");
					}
					break;
					
				case 3:
					System.out.print("고객 이름: ");
					String queryName = scanner.nextLine();
						if(accountMap.containsKey(queryName))
							System.out.println(queryName = "님의 잔액은 "+accountMap.get(queryName)+"원 입니다.");
						else
							System.out.println("해당 고객의 계좌가 존재하지 않습니다.");
						break;
						
				case 4:
					System.out.println("전체 계좌 현황 : ");
					for(String name : accountMap.keySet())
						System.out.println(name+" : "+accountMap.get(name)+"원");
					break;
					
				case 5:
					System.out.println("프로그램 종료");
					scanner.close();
					return;
					
				default:
					System.out.println("올바른 메뉴 번호를 입력해 주세요.");
				
			}
		}
	}
}














