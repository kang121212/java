/*
 * 실습문제 3
 * 다음 코드를 Calc 클래스는 util 패키지에 MainApp 클래스는 main 패키지로 분리 작성하라
 */

package appl;

class Calc{
	private int x, y;
	public Calc(int x, int y) { this.x = x; this.y = y;}
	public int sum() { return x+y;}
}

public class Exam_3 {
	public static void main(String[] args) {
		Calc c = new Calc(10,20);
		System.out.println(c.sum());
	}
}
