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
