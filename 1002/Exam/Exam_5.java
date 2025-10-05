/* 연습문제 5
 * Point 클래스를 상속받아 3차원의 점을 나타내는 Point3D클래스를 작성하라.
 * 다음 main() 메소드를 포함하여 실행 결과와 같이 출력되게 하라.
 */
package Exam_1002;

class Point5{
	private int x=0, y=0;
	public Point5(int x, int y) {
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
class Point3D extends Point5{
	private int z=0;
	public Point3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	public int getZ() {
		return z;
	}
	public void moveUp(int a) {
		z = z+a;
	}
	public void moveDown(int b) {
		z = z-b;
	}
	public String toString() {
		return "("+getX()+", "+getY()+", "+getZ()+")의 점";
	}
	public void move(int x, int y) {
		super.move(x, y);
	}
	public void move(int x, int y, int z) {
		super.move(x, y);
		this.z=z;
	}
}
	
public class Exam_5 {
	public static void main(String[] args) {
		Point3D p = new Point3D(3, 2, 1);
		System.out.println(p.toString() + "입니다.");
		p.moveUp(3);	//z 축으로 3이동
		System.out.println(p.toString() + "입니다.");
		p.moveDown(2);	// z 축으로 -2이동
		System.out.println(p.toString() + "입니다.");
		p.move(5, 5);	// x = 5, y = 5으로 이동
		System.out.println(p.toString() + "입니다.");
		p.move(100, 200, 300);
		System.out.println(p.toString() + "입니다.");
	}
}
