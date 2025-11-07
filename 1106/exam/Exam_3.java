/*
 * 실습문제 3
 * "그만"이 입력될 때까지 주식 종목과 주가를 입력받아 해시맵에 저장하고, 다시 주식종목을 입력받아
 * 주가를 출력하는 프로그램을 작성하라. 해시맵은 HashMap<String.Integer>을 이용하면 된다.
 */

package generic;
import java.util.HashMap;
import java.util.Scanner;

public class Exam_3 {
	public static void main(String[] args) {
		HashMap<String,Integer> stockMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("주식 종목과 주가를 입력하세요");
		
		while(true) {
			System.out.print("종목명 >> ");
			String stockName = scanner.nextLine();
			if(stockName.equals("그만")) {
				break;
			}
			System.out.print("주가 >> ");
			try {
				int price = Integer.parseInt(scanner.nextLine());
				stockMap.put(stockName, price);
			} catch(NumberFormatException e) {
				System.out.println("숫자 형식의 주가를 입력해주세요");
			}
		}
		
		System.out.println("\n저장된 주식 정보를 조회합니다.");
		while (true) {
			System.out.print("조회할 종목명 입력");
			String query = scanner.nextLine();
			if(query.equals("그만"))
				break;
			if(stockMap.containsKey(query))
				System.out.println(query+"의 주가는 " +stockMap.get(query)+"원 입니다.");
			else
				System.out.println("해당 종목은 존재하지 않습니다.");
		}
		scanner.close();
		System.out.println("프로그램 종료");
	}
}
