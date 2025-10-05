/* 연습문제 7
 * Point 클래스를 상속받아 3차원 색 점을 나타내는 Point3DColor 클래스를 작성하라.
 * 다음 main() 메소드를 포함하여 실행 결과와 같이 출력되게 하라.
 */
package Exam_1002;

class Point7{
	private int x=0, y=0;
	public Point7(int x, int y) {
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

class Point3DColor extends Point7{
	private int z;
	private String color7;
	
	public Point3DColor(int x, int y, int z, String color7) {
		super(x,y);
		this.z=z;
		this.color7=color7;
	}
	public int getZ() {
		return z;
	}
	public String getColor() {
        return color7;
    }
	public void move(Point3DColor p) {
		super.move(p.getX(), p.getY());
		this.z=p.getZ();
		this.color7 = p.getColor();
	}
	

	public String toString() {
		return "("+getX()+", "+getY()+", "+getZ()+")의 점";
	}
}

public class Exam_7 {
	public static void main(String[] args) {
		Point3DColor p = new Point3DColor(10,20,30,"RED");
		System.out.println(p.toString()+"입니다.");
		Point3DColor q = new Point3DColor(1,2,3,"BLUE");
		p.move(q);	//점 q를 점 q의 위치로 이동
		System.out.println(p.toString()+"입니다.");
		Point3DColor r = new Point3DColor(1,2,3,"RED");
		if(p.equals(r))	System.out.println("예. 같은 위치, 같은 색의 점입니다.");
		else System.out.println("아니오");
	}
}
