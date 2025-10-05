/* 연습문제 2
 * 다음 main() 메소드와 실행 결과를 참고하여 ColorTV를 상속받는 SmartTV 클래스를 작성하라.
 */

package Exam_1002;

class TV1{
	private int size;
	public TV1(int size) { this.size=size;}
	protected int getSize() {return size;}
	
}
class ColorTV1 extends TV1{
	private int color;
	
	public ColorTV1(int size, int color) {
		super(size);
		this.color=color;
	}
	protected int getColor() {return color;}
	public void printProperty() {
		System.out.println(getSize()+"인치 "+color+"컬러");
	}
}
class SmartTV extends ColorTV1{
	private String address;
	
	public SmartTV(String address, int size, int color) {
		super(size,color);
		this.address = address;
	}
	public void printProperty() {
		System.out.println("나의 SmartTV는 "+address+" 주소의 "+getSize()+"인치 "+getColor()+"컬러");
	}
}

public class Exam_2 {
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77, 2000000);
		//"192.168.0.5" 주소의 77인치 2000000 컬러 TV
		smartTV.printProperty();
	}
}
