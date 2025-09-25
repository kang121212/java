package Intro;

public class Pizza {
	int radius;
	String name;
	double getArea() {
		return 3.14 * radius * radius;
	}
	public Pizza() {	//기본 생성자 ( 안만들어준다 )
		
	}
	public Pizza(int radius, String name) {
		this.radius = radius;
		this.name = name;
	}
	
	public static void main(String[] args) {
		Pizza p1 = new Pizza(5,"청담피자");	//두번째꺼 실행
		Pizza p2 = new Pizza();				//첫번째꺼 실행
		
		//p1.radius = 5;
		p2.radius = 10;
		//p1.name = "도미노";
		p2.name = "미스터";
		
		System.out.println(p1.name+"피자의 크기는 = "+p1.getArea());
		System.out.println(p1.name+"피자의 크기는 = "+p2.getArea());
	}
}
