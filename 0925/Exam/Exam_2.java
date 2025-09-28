/*
 * 실습문제 2
 * Cube는 직육면체를 표현하는 클래스이다. 다음 main()메소드와 실행결과를 참고하여 Cube 클래스를 작성하라.
 */

package Exam_0925;

class Cube {
    private int width;
    private int depth;
    private int height;

    // public 생성자
    public Cube(int width, int depth, int height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    // public 메소드: 부피 계산
    public int getVolume() {
        return width * depth * height;
    }

    // public 메소드: 크기 증가
    public void increase(int w, int d, int h) {
        width += w;
        depth += d;
        height += h;
    }

    // public 메소드: 부피가 0인지 확인
    public boolean isZero() {
        return getVolume() == 0;
    }
}



public class Exam_2 {
	public static void main(String[] args) {
		Cube cube = new Cube(1, 2, 3); //가로, 세로, 높이가 1,2,3인 큐브 객체 생성
		System.out.println("큐브의 부피는 "+ cube.getVolume());
		cube.increase(1,2,3);	//가로 세로 높이 각각 1씩 증가
		System.out.println("큐브의 부피는 "+ cube.getVolume());
		if(cube.isZero())
			System.out.println("큐브의 부피는 0");
		else
			System.out.println("큐브의 부피는 0이 아님");
	}
}
