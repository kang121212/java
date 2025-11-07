/*
 * 실습문제 9
 * Vector<Shape>을 이용하여 그래픽 편집기를 만들어보자. 본문 5.6절과 5.7절에서
 * 사례로 든 추상 클래스 Shape과 Line, Rect, Circle 클래스 코드를 완성하고
 * 이를 활용하여 "삽입", "삭제", "모두 보기", "종료"의 4가지 그래픽 편집 기능을 가진
 * 프로그램을 작성하라. 5장 실습문제 14번을 Vector<Shape>을 이용하여 재작성하는 연습이다.
 * Vector를 이용하면 5장 실습문제 14번 보다 훨씬 간단히 작성됨을 경험할 수 있다.
 */

package generic;

import java.util.Scanner;
import java.util.Vector;

abstract class Shape{
	public abstract void draw();
}
class Line extends Shape{
	public void draw() {
		System.out.println("Line");
	}
}
class Rect extends Shape{
	public void draw() {
		System.out.println("Rect");
	}
}
class Circle extends Shape{
	public void draw() {
		System.out.println("Circle");
	}
}

public class Exam_9 {
	private Vector<Shape> shapeList = new Vector<>();
	
	public void runEditor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("그래픽 편집기입니다.");
		System.out.println("삽입:1, 삭제:2, 모두보기:3, 종료:4");
		
		while(true) {
			System.out.print("명령어 입력>>");
			int command = Integer.parseInt(scanner.nextLine());
			
			switch(command) {
			case 1:
				System.out.print("도형 종류(Line:1, Rect:2, Circle:3)>>");
				int shapeType = Integer.parseInt(scanner.nextLine());
				switch (shapeType) {
				case 1: shapeList.add(new Line()); break;
				case 2: shapeList.add(new Rect()); break;
				case 3: shapeList.add(new Circle()); break;
				default: System.out.println("잘못된 번호입니다.");
				}
				break;
			case 2:
				System.out.print("삭제할 도형의 인덱스>>");
				int index = Integer.parseInt(scanner.nextLine());
				if(index < 0 || index >= shapeList.size())
					System.out.println("삭제할 수 없습니다.");
				else
					shapeList.remove(index);
				break;
				
			case 3:
				for(int i=0; i<shapeList.size(); i++) {
					System.out.print(i+": ");
					shapeList.get(i).draw();
				}
				break;
				
			case 4:
				System.out.println("그래픽 편집기를 종료합니다.");
				scanner.close();
				return;
				
			default:
				System.out.println("잘못된 명령입니다.");
					
			}
		}
		
	}
	public static void main(String[] args) {
		Exam_9 editor = new Exam_9();
		editor.runEditor();
	}
}















