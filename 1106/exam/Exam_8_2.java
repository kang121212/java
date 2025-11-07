/*
 * 실습문제 8_2
 * Vector<Student> 대신 '학생 이름'을 '키'로 하는 HashMap<String, Student>
 * 컬랙션을 활용하여 다시 프로그램을 작성하라. HashMap을 사용하여 저장된 학생들을
 * 모두 출력하면 저장 순으로 출력되지 않을 수 있음에 유의하라.
 */

package generic;

import java.util.HashMap;
import java.util.Scanner;


class Student2 {
    private String name;
    private String major;
    private String studentId;
    private double gpa;

    public Student2(String name, String major, String studentId, double gpa) {
        this.name = name;
        this.major = major;
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return "이름: " + name + ", 전공: " + major + ", 학번: " + studentId + ", 학점 평균: " + gpa;
    }
}

public class Exam_8_2 {
	private HashMap<String, Student> studentMap = new HashMap<>();

    public void inputStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("학생 정보를 입력하세요.");

        for (int i = 0; i < 4; i++) {
            System.out.print("이름: ");
            String name = scanner.nextLine();

            System.out.print("전공: ");
            String major = scanner.nextLine();

            System.out.print("학번: ");
            String studentId = scanner.nextLine();

            System.out.print("학점 평균: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            studentMap.put(name, new Student(name, major, studentId, gpa));
        }
        scanner.close();
    }

    public void printAllStudents() {
        System.out.println("\n모든 학생 정보:");
        for (Student s : studentMap.values()) {
            System.out.println(s);
        }
    }

    public void printScholarshipStudents() {
        System.out.println("\n장학생 명단 (학점 평균 4.0 이상):");
        for (Student s : studentMap.values()) {
            if (s.getGpa() >= 4.0) {
                System.out.println(s);
            }
        }
    }

    public void searchStudentByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n학생 이름으로 정보 검색합니다. (종료하려면 '그만' 입력)");

        while (true) {
            System.out.print("이름: ");
            String name = scanner.nextLine();
            if (name.equals("그만")) break;

            Student s = studentMap.get(name);
            if (s != null) {
                System.out.println(s);
            } else {
                System.out.println("해당 학생 정보가 없습니다.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Exam_8_2 manager = new Exam_8_2();
        manager.inputStudents();
        manager.printAllStudents();
        manager.printScholarshipStudents();
        manager.searchStudentByName();
    }

}
