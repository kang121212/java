/*
 * 실습문제 4
 * 다음 2차원 배열n을 실행 사례와 같이 출력하는 프로그램을 작성하라.
 */
package exam_0918;

public class Exam_4 {

	public static void main(String[] args) {
		int n[][] = {{1,2,3}, {1,2}, {1}, {1,2,3}, {1,2,3,4}};
		for(int i =0; i<n.length; i++) {
			for(int a=0; a<n[i].length; a++) {
				System.out.print(n[i][a] + " ");
			}
			System.out.println();
		}

	}

}
