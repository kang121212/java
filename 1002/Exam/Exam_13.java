/* 연습문제 13
 * 황수연 학생은 다음 3개의 필드와 메소드를 가진 4개의 클래스 Add, Sub, Mul, Div를
 * 작성하려고 한다. String errorMsg 필드 : 연산 도중 발생한 오류 메시지 저장.null이면 오류 없음,
 * int 타입의 a,b 필드 : 2개의 피연산자 / void setValue(int a, int b) : 피연산자 값을 
 * 전달받아 객체 내에 저장 / int calculate() : 클래스의 목적에 맞는 연산을 실행하고 결과 리턴
 * 황수연은 Add, Sub, Mul, Div 클래스에 공통된 필드와 메소드가 존재하므로 추상 클래스 Calc
 * 를 작성하고 Calc를 상속받아 만들 수 있다고 판단하였다. 또한 main()메소드에서 다음 실행 사례와 
 * 같이 2개의 정수와 연산자를 입력받은 후, Add, Sub, Mul, Div 중 이 연산을 처리할 수 있는
 * 객체를 생성하고 setValue()와 calculate()를 순차적으로 호출하여 결과를 출력하고, 연산 도중
 * 오류가 발생하면 오류 내용을 errorMsg에 저장하기로 판단하였다.
 * 황수연의 판단처럼 추상 클래스 Calc와 이를 상속받는 Add, Sub, Mul, Div를 
 * 구현하고, 이들을 활용하여 다음 실행 결과와 같이 사용자가 입력한 연산 명령을 실행하는 Calculator 클래스를
 * 작성하라. 연산에 오류가 발생하면 프로그램은 종료한다.
 */
package Exam_1002;

import java.util.Scanner;

abstract class Calc{
	protected int a,b;
	protected String errorMsg = null;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public abstract int calculate();
}
class Add extends Calc{
	public int calculate() {
		return a+b;
	}
}
class Sub extends Calc{
	public int calculate() {
		return a-b;
	}
}
class Mul extends Calc{
	public int calculate() {
		return a*b;
	}
}
class Div extends Calc{
	public int calculate() {
		if(b==0) {
			errorMsg = "오류:0으로 나눌 수 없습니다.";
			return 0;
		}
		return a/b;
	}
}


public class Exam_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하세요 >> ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String op = scanner.next();
		
		Calc calc = null;
		switch(op) {
		case "+":
			calc = new Add();
			break;
		case "-":
			calc = new Sub();
			break;
		case "*":
			calc = new Mul();
			break;
		case "/":
			calc = new Div();
			break;	
		default:
			System.out.println("지원하지 않는 연산자입니다.");
			scanner.close();
			return;
		}
		calc.setValue(a, b);
		int result = calc.calculate();
		
		if(calc.getErrorMsg()!=null) {
			System.out.println(calc.getErrorMsg());
		}else {
			System.out.println("결과 : "+result);
		}
		scanner.close();
	}
}











