/* 연습문제 1
 * 다음 main()메소드와 실행 결과를 참고하여 TV를 상속받은 ColorTV클래스를 작성하라.
 */

package Exam_1002;

class TV{
	private int size;
	public TV(int size) { this.size=size;}
	protected int getSize() {return size;}
	
}
class ColorTV extends TV{
	private int color;
	
	public ColorTV(int size, int color) {
		super(size);
		this.color=color;
	}
	public void printProperty() {
		System.out.println(getSize()+"인치 "+color+"컬러");
	}
}

public class Exam_1 {
	public static void main(String[] args) {
		ColorTV myTv = new ColorTV(65, 65536);	//65인치 크기에 65536 컬러TV
		myTv.printProperty();
	}
}
