/* 연습문제 4
 * Point를 상속받아 색을 가진 점을 나타내는 ColorPoint2클래스를 작성하라. 
 * 다음 main() 메소드를 포함하여 실행결과와 같이 출력되게 하라.
 */
package Exam_1002;

class Point4{
	private int x=0, y=0;
	public Point4(int x, int y) {
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
class ColorPoint2 extends Point4{
	private String color2;
	public ColorPoint2() {
		super(0,0);
		this.color2="WHITE";
	}
	public ColorPoint2(int x, int y) {
		super(x,y);
		this.color2="BLACK";
	}
	public ColorPoint2(int x, int y, String color2) {
		super(x, y);
		this.color2 = color2;
	}
	public void set(int x, int y) {
		move(x,y);
	}
	public void setColor(String color2) {
		this.color2=color2;
	}
	public String toString() {
		return color2+"색의 ("+getX()+", "+getY()+")의 점";
	}
	public double getDistance(Point4 p) {
        int dx = getX() - p.getX();
        int dy = getY() - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

}

public class Exam_4 {
	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2();	//(0,0)위치의 "WHITE"색 점
		System.out.println(zeroPoint.toString() + "입니다.");
		ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
		// (10, 10)위치의 "RED" 색 점
		cp.setColor("BLUE");
		cp.set(10, 20);
		System.out.println(cp.toString()+"입니다.");
		ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
		//(100, 100)위치의 "BLACK" 점
		System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
	}
}
//결과 : BLUE색의 (10,20)의 점입니다.