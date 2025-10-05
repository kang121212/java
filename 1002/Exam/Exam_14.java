/* 연습문제 14
 *  텍스트로 입출력하는 간단한 그래픽 편집기를 만들어보자. 본문 5.6절과 5.7절에서 
 *  사례로 보인 추상 클래스 Shape와 Line, Rect, Circle 클래스 코드를 잘 완성하고
 *  이를 활용해서 다음 실행 예시처럼 "삽입", "삭제", "모두 보기", "종료"의 4가지
 *  그래픽 편집 기능을 가진 클래스 GraphicEditor를 작성하라.
 */
package Exam_1002;

import java.util.Scanner;

abstract class Shape{
	private Shape next;
	public Shape() {next=null;}
	public void setNext(Shape obj) {next=obj;}//링크 연결
	public Shape getNext() {return next;}
	public abstract void draw();//추상메소드
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
class GraphicEditor{
	private Shape head = null;
	private Scanner scanner = new Scanner(System.in);
	public void run() {
		System.out.println("그래픽 편집기를 실행합니다.");
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4) >>");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				insertShape();
				break;
			case 2:
				deleteShape();
				break;
			case 3:
				viewAll();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;	
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	private void insertShape() {
		System.out.print("Line(1), Rect(2), Circle(3)>> ");
		int type = scanner.nextInt();
		Shape shape = null;
		switch(type) {
		case 1: shape = new Line(); break;
		case 2: shape = new Rect(); break;
		case 3: shape = new Circle(); break;
		default:
			System.out.println("잘못된 도형입니다.");
			return;
		}
		if(head ==null) {
			head = shape;
		}else {
			Shape temp = head;
			while(temp.getNext()!=null) {
				temp = temp.getNext();
			}
			temp.setNext(shape);
		}
	}
	private void deleteShape() {
		System.out.print("삭제할 도형의 위치 >>");
		int pos = scanner.nextInt();
		if(head ==null) {
			System.out.println("삭제할 도형이 없습니다.");
			return;
		}
		if(pos==1) {
			head = head.getNext();
			return;
		}
		Shape prev = head;
		Shape curr = head.getNext();
		int count = 2;
		
		while(curr!=null) {
			if(count==pos) {
				prev.setNext(curr.getNext());
				return;
			}
			prev = curr;
			curr=curr.getNext();
			count++;
		}
		System.out.println("삭제할 위치에 도형이 없습니다.");
	}
	private void viewAll() {
		Shape temp = head;
		while(temp !=null) {
			temp.draw();
			temp=temp.getNext();
		}
	}
}

public class Exam_14 {
	public static void main(String[] args) {
		GraphicEditor editor = new GraphicEditor();
		editor.run();
	}
}


















