/* 연습문제 6
 * 다음 멤버를 가지고 사각형을 표현한는 Rectangle 클래스를 작성하라.
 * int 타입의 x,y,width, height 필드 : 사각형을 구성하는 점과 크기 정보
 * x,y,width,height를 매개변수로 전달받아 필드들을 초기화하는 생성자
 * boolean is Suare():정사각형이면 true,아니면 false를 리턴
 * boolean contains(Rectangle r): 현재 사각형 내부에 매개변수로
 * 받은 사각형 r이 있으면 true 아니면 false 리턴
 * main() 메소드와 실행 결과는 다음과 같다. 
 */

package Exam_0925;

class Rectangle{
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	public boolean isSquare() {
		return width==height;
	}
	public boolean contains(Rectangle r) {
        // 현재 사각형의 범위
        int x1 = this.x;
        int y1 = this.y;
        int x2 = this.x + this.width;
        int y2 = this.y + this.height;

        // 매개변수 사각형의 범위
        int rx1 = r.x;
        int ry1 = r.y;
        int rx2 = r.x + r.width;
        int ry2 = r.y + r.height;

        return (rx1 >= x1 && ry1 >= y1 && rx2 <= x2 && ry2 <= y2);

	}
	public void show() {
		System.out.println("("+x+"."+y+")에서 크기가 "+width+"*"+height+"인 사각형");
	}
}


public class Exam_6 {
	public static void main(String[] args) {
		Rectangle a = new Rectangle(3,3,6,6);//(3.3)에서 6*6사각형
		Rectangle b = new Rectangle(4,4,2,3);
		a.show();
		if(a.isSquare()) System.out.println("a는 정사각형 입니다.");
		else System.out.println("a는 직사각형 입니다.");
		if(a.contains(b)) System.out.println("a는 b를 포함합니다.");
	}
}
