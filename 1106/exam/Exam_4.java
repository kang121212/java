/*
 * 실습문제 4
 * 쇼핑 후 전체 경비를 계산하는 프로그램을 작성하라. 구입 가능한 품목은 실행 예시와
 * 같이 고추장, 만두 등 8가지 이다.
 * 1) 구입 가능한 품목과 가격을 HashMap<String.Integer>에 미리 저장해두고 사용자가 구입한
 * 물건들의 전체 가격을 계산하도록 작성하라.
 */

package generic;

import java.util.HashMap;
import java.util.Scanner;

public class Exam_4 {
	public static void main(String[] args) {
		HashMap<String,Integer> itemPriceMap = new HashMap<>();
		itemPriceMap.put("고추장", 3000);
		itemPriceMap.put("만두", 5000);
		itemPriceMap.put("김치", 4000);
		itemPriceMap.put("라면", 1200);
		itemPriceMap.put("쌀", 15000);
		itemPriceMap.put("계란", 6000);
		itemPriceMap.put("우유", 2500);
		itemPriceMap.put("두부", 2000);
		
		Scanner scanner = new Scanner(System.in);
		int totalCost = 0;
		
		System.out.println("구입할 품목을 입력하세요");
		while(true) {
			System.out.print("품목명: ");
			String item = scanner.nextLine();
			if(item.equals("그만"))
				break;
			if(itemPriceMap.containsKey(item))
				totalCost+=itemPriceMap.get(item);
			else
				System.out.println("해당 푸목은 목록에 없습니다.");
		}
		System.out.println("전체 경비는 " + totalCost + "원 입니다.");
		scanner.close();
	}
}
