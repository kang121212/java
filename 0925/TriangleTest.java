package Intro;
class Triangle{		//public 안붙인다!!! main 메소드 포함한 클래스에만 public 붙인다.
	int height, width;
	
	double getArea() {
		return 0.5 * height * width;
	}
}
public class TriangleTest {
	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		t1.height = 10;
		t1.width = 20;
		System.out.println("삼각형의 면적 = "+ t1.getArea());
	}
}
