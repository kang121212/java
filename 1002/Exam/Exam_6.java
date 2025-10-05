/* 연습문제6
 * Point 클래스를 상속받아 양수만 가능한 점을 나타내는 PositivePoint클래스를 작성하라.
 * 다음 main() 메소드를 포함하여 실행 결과와 같이 출력되게 하라.
 * 출력 화면과 main 메소드에서 입력 받는 매개변수가 일치하지 않는것 같습니다.;;
 */
package Exam_1002;

class Point6{
	private int x=0, y=0;
	public Point6(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class PositivePoint extends Point6{
	public PositivePoint() {
		super(1, 1); // 기본 생성자: 음수 방지용 디폴트
	}

	public PositivePoint(int x, int y) {
		super(x < 0 && y < 0 ? x : 1, x < 0 && y < 0 ? y : 1); 
		// 음수 좌표 방지
	}
	public String toString() {
		return "("+getX()+", "+getY()+")의 점";
	}
	public void move(int x, int y) {
		if (x > 0 && y > 0) {
			super.move(x, y);
		}
		// 음수 좌표면 이동하지 않음
	}

}

public class Exam_6 {
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint(10, 10);	//(10,10)의 점
		p.move(5,5);	//p는 (5,5) 점
		System.out.println(p.toString() + "입니다.");
		p.move(2,-2);	//점 p는 양수 공간만 가능, 그러므로 이동 없음
		System.out.println(p.toString() + "입니다.");
		PositivePoint q = new PositivePoint(-10,-10);	//음수 점 불가, 디폴트(1,1)생성
		System.out.println(q.toString() + "입니다.");
	}
}
