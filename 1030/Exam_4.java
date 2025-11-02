/*
 * 실습문제 4
 * 다음 코드를 수정하여 Shape 클래스는 graphic 패키지에, Circle 클래스는  component 패키지에,
 * GraphicEditor 클래스는 app 패키지에 분리 작성하라.
 */

package appl;

class Shape{
	public void draw() {
		System.out.println("Shape");
	}
}
class Circle extends Shape{
	public void draw() {
		System.out.println("Circle");
	}
}

public class Exam_4 {
	public static void main(String[] args) {
		Shape shape = new Circle();
		shape.draw();
	}
}
