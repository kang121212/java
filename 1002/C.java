package q;

import p.A;	// 다른 패키지에 클래스 사용 임포트

public class C {
	public static void main(String[] args) {
		A a1= new A;
		a1.pub=1;
		a1.pro=2;
		a1.def=3;
		a1.pri=4;
	}
}
