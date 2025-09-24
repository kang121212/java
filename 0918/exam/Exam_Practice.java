/*
 * 오픈 챌린지
 * 숨겨진 카드의 수를 맞추는 게임을 만들어 보자.
 * 0에서 99까지의 임의의 수를 가진 카드를 한 장 숨기고 이 카드의 수를 맞추는 게임이다.
 * 아래의 화면과 같이 카드 속의 수가 77인 경우를 보자. 수를 맞추는 사람이 55라고 입력함녀 "더높게", 다시 70을 
 * 입력하면 "더 높게" 라는 식으로 범위를 좁혀가면서 수를 맞춘다. 게임을 반복하기 위해 y/n 를 묻고, n인 경우 종료된다.
 */
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
