/*
 * 실습문제 15
 * 다음 코드는 2개의 정수를 입력ㅂ다아 곱을 구하는 프로그램이다. 이 프로그램은 실행 중 정수가 아닌 것이 입력되면
 * 라인 3이나 4에서 InputMismatchException 예외가 발생하고 종료되어 버린다. 이 프로그램을 수정하여 실행 사례와 
 * 같이 정수가 입력될때까지 입력받고 곱을 출력하도록 하라.
 */
package exam_0918;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Exam_15 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean tf=true;
		while(tf) {
			try {
				System.out.print("곱하고자 하는 정수 2개 입력 >> ");
				int n = scn.nextInt();
				int m = scn.nextInt();
				System.out.println(n+"x"+m+"="+(n*m));
			}catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요!");
				scn.nextLine();
				break;
			}
		}
	
		scn.close();
	}

}
