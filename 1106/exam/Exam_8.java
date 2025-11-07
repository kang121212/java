/*
 * 실습문제 8
 * 학정 정보를 나타내는 Student 클래스에서는 이름, 전공, 학번, 학점 평균을 저장하는 필드가 있다.
 * 다음 조건에 맞춘 프로그램을 작성하라.
 * 1) 학생마다 Student 객체를 생성하고 4명의 학생 정보를 Vector<Student>
 * 컬랙션에 저장한 후, 벡터에 저장된 모든 학생의 정보를 출력하고, 장학생(학점 평균 4.0이상)
 * 을 선발하여 출력하라. 또한 학생의 이름을 입력받아 학생의 정보를 출력하라.
 */

package generic;

import java.util.Scanner;
import java.util.Vector;

class Student{
	private String name;
	private String major;
	private String studentId;
	private double gpa;
	
	public Student(String name, String major, String studentId, double gpa) {
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
		return "이름: "+name+", 전공: "+major+", 학번: "+studentId+", 학점 평균: "+gpa;
	}
}

public class Exam_8 {
	Vector<Student> studentList = new Vector<>();
	
	public void inputStudents() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생 정보를 입력하세요.");
		
		for(int i = 0; i<4; i++) {
			System.out.print("이름: ");
			String name = scanner.nextLine();
			
			System.out.print("전공: ");
			String major = scanner.nextLine();
			
			System.out.print("학번: ");
			String studentId = scanner.nextLine();
			
			System.out.print("학점 평균: ");
			double gpa = Double.parseDouble(scanner.nextLine());
			
			studentList.add(new Student(name, major, studentId, gpa));
		}
		scanner.close();
	}
	
	public void printAllStudents() {
		System.out.println("\n모든 학생 정보: ");
		for(Student s : studentList) {
			System.out.println(s);
		}
	}
	public void printScholarshipStudents() {
		System.out.println("\n장학생 명단 : ");
		for(Student s : studentList) {
			if(s.getGpa()>=4.0)
				System.out.println(s);
		}
	}
	public void searchStudentByName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n학생 이름으로 정보 검색합니다.");
		
		while(true) {
			System.out.print("이름: ");
			String name = scanner.nextLine();
			if(name.equals("그만")) break;
			
			boolean found = false;
			for(Student s : studentList) {
				if(s.getName().equals(name)) {
					System.out.println(s);
					found = true;
					break;
				}
			}
			if(!found) {
				System.out.println("해당 학생 정보가 없습니다.");
			}
		}
		scanner.close();
	}
	public static void main(String[] args) {
		Exam_8 manager = new Exam_8();
		manager.inputStudents();
		manager.printAllStudents();
		manager.printScholarshipStudents();
		manager.searchStudentByName();
	}
	
}
























