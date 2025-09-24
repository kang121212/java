/*
 * 실습문제 13
 * 과목과 학점이 들어있는 다음 2개의 배열을 활용하여, 과목명을 입력받아 학점을 
 * 출력하는 프로그램을 작성하라. "그만"이 입력되면 프로그램을 종료한다.
 */
package exam_0918;

import java.util.Scanner;

public class Exam_13 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String subject;
        String[] course = {"C", "C++", "Python", "Java", "HTML5"};
        String[] grade = {"A", "B+", "B", "A+", "D"};

        while (true) {
            System.out.print("과목 >> ");
            subject = scn.next();

            if (subject.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            boolean found = false;
            for (int i = 0; i < course.length; i++) {
                if (course[i].equals(subject)) {
                    System.out.println(subject + " 학점은 " + grade[i]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(subject + "는 없는 과목입니다.");
            }
        }
        scn.close();
    }
}
