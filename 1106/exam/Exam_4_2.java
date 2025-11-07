/*
 * 실습문제 4
 * 쇼핑 후 전체 경비를 계산하는 프로그램을 작성하라. 구입 가능한 품목은 실행 예시와
 * 같이 고추장, 만두 등 8가지 이다.
 * 2) HashMap<String.Integer> 대신, 품목과 가격을 ArrayList<String>과
 * ArrayList<Integer>에 각각 저장해두고, 사용자가 구입한 물건들의 전체 가격을 계산하도록 하라.
 */

package generic;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_4_2 {
	public static void main(String[] args) {
		ArrayList<String> items = new ArrayList<>();
		ArrayList<Integer> prices = new ArrayList<>();
		
		items.add("고추장"); prices.add(3000);
		items.add("만두"); prices.add(5000);
		items.add("김치"); prices.add(4000);
		items.add("라면"); prices.add(1200);
		items.add("쌀"); prices.add(15000);
		items.add("계란"); prices.add(6000);
		items.add("우유"); prices.add(2500);
		items.add("두부"); prices.add(2000);
		
		Scanner scanner = new Scanner(System.in);
		int totalCost = 0;
		System.out.println("구입할 품목을 입력하세요.");
		
		while (true) {
			System.out.print("품목명 : ");
			String input = scanner.nextLine();
			
			if(input.equals("그만"))
				break;
			boolean found = false;
			for(int i=0; i<items.size(); i++) {
				if(items.get(i).equals(input)) {
					totalCost+=prices.get(i);
					found = true;
					break;
				}
			}
			if(!found)
				System.out.print("해당 품목은 목록에 업습니다.");
			
		}
		System.out.println("전체 경비는 " + totalCost + "원입니다.");
		scanner.close();
	}
}












