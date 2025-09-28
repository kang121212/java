/* 연습문제 10
 * 한 달의 다이어리를 관리하는 프로그램을 작성하라.
 * 한 달은 30일로 정한다. 이 프로그램은 사용자로부터 날짜와 기억할 일을 간단히 저장하거나, 
 * 검색하는 등의 기능을 수행하며, 실행 예시는 다음과 같다.
 * 기억할 일은 빈칸 없이 4글자 이하의 문자열만 다룬다.
 */
package Exam_0925;

import java.util.Scanner;

class DayDiary {
    private String work;

    public void setWork(String work) {
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void show() {
        if (work == null)
            System.out.println("...");
        else
            System.out.println(work);
    }
}

class MonthDiary {
    private DayDiary[] days;

    public MonthDiary() {
        days = new DayDiary[30];
        for (int i = 0; i < days.length; i++) {
            days[i] = new DayDiary();
        }
    }

    public void input(int day, String work) {
        days[day - 1].setWork(work);
    }

    public void view() {
        for (int i = 0; i < 5; i++) {
            for (int ii = 0; ii < 7; ii++) {
                int day = i * 7 + ii + 1;
                if (day > 30) break;
                System.out.printf("%2d일: ", day); // 날짜를 보기 좋게 출력
                days[day - 1].show();            // 해당 날짜의 기억할 일 출력
            }
        }
    }

    public void run() {
        Scanner scn = new Scanner(System.in);
        System.out.println("한 달의 기억할 일을 관리합니다.");
        while (true) {
            System.out.print("할 일(입력:1, 보기:2, 종료:3) >> ");
            int cmd = scn.nextInt();
            if (cmd == 1) {
                System.out.print("날짜(1~30)? ");
                int day = scn.nextInt();
                System.out.print("할 일(4글자 이하, 공백 없이)? ");
                String work = scn.next();
                input(day, work);
            } else if (cmd == 2) {
                view();
            } else if (cmd == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        scn.close();
    }
}

// ✅ main()이 포함된 클래스 이름은 파일 이름과 동일하게!
public class Exam_11 {
    public static void main(String[] args) {
        MonthDiary diary = new MonthDiary();
        diary.run();
    }
}