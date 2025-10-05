/* 연습문제 15
 * 다음은 도형을 묘사한 Shape 인터페이스이다. 다음 main() 메소드와 실행 결과를 참고하여,
 * Shape 인터페이스를 상속받아 구현한 클래스 Circle, Oval, Rect를 작성하고 main()
 * 메소드를 포함하는 ShapeEx 클래스를 작성하여라.
 */
package Exam_1002;

interface Shape5{
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.print("--- 다시 그립니다.");
		draw();
	}
}
class Circle3 implements Shape5{
	private int radius;
	public Circle3(int radius) {
		this.radius = radius;
	}
	public void draw() {
		System.out.println("반지름이 " + radius + "인 원입니다.");
	}
	public double getArea() {
		return PI * radius * radius;
	}
}
class Oval implements Shape5{
	private int width, height;
	public Oval(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public void draw() {
		System.out.println(width+"*"+height+"에 내접하는 타원입니다.");
	}
	public double getArea() {
		return PI*width*height /4.0;
	}
}
class Rect4 implements Shape5{
	private int width, height;
	public Rect4(int width, int height) {
		this.width = width;
		this.height=height;
	}
	public void draw() {
		System.out.println(width+"*"+height+" 크기의 사각형입니다.");
	}
	public double getArea() {
		return width*height;
	}
}


public class Exam_15 {
	public static void main(String[] args) {
		Shape5 [] list = new Shape5[3];	// Shape를 상속받은 클래스 객체의 레퍼런스 배열
		list[0] = new Circle3(5);	//반지름5인 원 객체
		list[1] = new Oval(20, 30);	//20*30 사각형에 내접하는 타원
		list[2] = new Rect4(10, 40);	//10*40 크기의 사격형
		for(int i=0; i<list.length; i++) list[i].redraw();
		for(int i=0; i<list.length; i++) System.out.println("면적은 " +list[i].getArea());
		
	}
}












