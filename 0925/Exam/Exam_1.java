/*
 * 실습문제 1
 * 자바 클래스를 만들어보자. 다음 main() 메소드를 실행하였을 때 예시와 같이 출력되도록 TV클래스를 작성하라.
 */

package Exam_0925;

class TV { 
    public String maker;
    public int inch;
    public int won;

    public TV(String maker, int inch, int won) {
        this.maker = maker;
        this.inch = inch;
        this.won = won;
    }

    public void show() {
        System.out.println(maker + "에서 만든 " + won + "만원 " + inch + "인치 TV");
    }
}

public class Exam_1 {
    public static void main(String[] args) {
        TV tv = new TV("Samsung", 50, 300);
        tv.show();
    }
}