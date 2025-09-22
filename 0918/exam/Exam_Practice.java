// 오픈첼린지
package exam_0918;

import java.util.Random;
import java.util.Scanner;

public class Exam_Practice {

	public static void main(String[] args) {
		int answer=-1;
		String yn = "y";
		
		Random r = new Random();
		Scanner scn = new Scanner(System.in);
		
		
		
		while(yn.equals("y")) {
			System.out.print("수를 결정하였습니다. 맞추어 보세요.");
			int k = r.nextInt(100);
			int count = 0;
			int min = 0;
			int max = 100;
			
			while(answer != k) {
				count++;
				System.out.println(min+"~"+max);
				System.out.print(count+"번째 시도 >> ");
				answer = scn.nextInt();
				if(answer < k) {
					System.out.println("더 높게");
					min = answer;
				}
				if(answer > k) {
					System.out.println("더 낮게");
					max = answer;
				}
			}
			System.out.println("정답입니다!");
			System.out.print("다시 하시겠습니까?(y/n) >> ");
			yn = scn.next();
		}
		
		scn.close();
	}

}
