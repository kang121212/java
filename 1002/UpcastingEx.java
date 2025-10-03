package basic;

public class UpcastingEx{
	public static void main(String[] args) {
		Person p;
		Student s = new Student("홍길동");
		p=s;	//name, id밖에 접근 안된다
	}
}

class Person {
	String name;
	String id;
	public Person(String name) {
		this.name = name;
	}
}

class Student extends Person{
	String grade;
	String department;
	
	public Student (String name) {
		super(name);
	}
}
