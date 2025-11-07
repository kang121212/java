/*
 * 실습문제 2
 * Scanner 클래스를 이용하여 0이 입력될 때까지 정수를 입력받아 벡터에 저장하라.
 * 그러고 나서 벡터에 있는 음수들만 모두 0으로 수정한 후, 벡터 전체를 검색하여 양수들의 합을 
 * 출력하라. 프로그램은 다음과 같이 main()을 구성하고 다른 메소드들을 구현하는 
 * 방식으로 작성하라. 여기서 벡터 v의 i번째 원소의 값을 0으로 바꿀 떼 v.set(i,0);를 사용하라.
 */

package generic;

import java.util.Scanner;
import java.util.Vector;

public class Exam_2 {
	private Vector<Integer> v = new Vector<Integer>();//멤버 변수

	public void read() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수를 입력하세요. 0을 입력하면 종료");
		
		while(true) {
			System.out.print("입력 >> ");
			int num = scanner.nextInt();
			if(num == 0) break;
			v.add(num);
		}
		scanner.close();
	}
	public void changeToZero() {
		for(int i = 0; i<v.size(); i++) {
			if(v.get(i)<0) {
				v.set(i,0);
			}
		}
	}
	public void showAll() {
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i));
		}
		System.out.println();
	}
	public int add() {
		int sum = 0;
		for(int i=0; i<v.size(); i++) {
			if(v.get(i)>0) {
				sum+=v.get(i);
			}
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		Exam_2 sp = new Exam_2();
		sp.read();
		sp.changeToZero();
		System.out.print("음수를 0으로 바꾸면 ");
		sp.showAll();
		System.out.println("양수들의 합은 " + sp.add());
	}
}

















