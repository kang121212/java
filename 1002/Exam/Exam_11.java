/* 연습문제 11
 * 다음 IStack 인터페이스를 상속받아 문자열을 저장하는 StringStack 클래스를 구현하라.
 * push() 는 스택의 꼭대기에 삽입하고 pop() 은 스택의 꼭대기에 저장된
 * 문자열을 리턴하는 메소드 이다. 그리고 StringStack 클래스를 활용하여 다음 실행 사례와 같이
 * 작동하는 main() 메소드를 가진 StackApp 클래스를 작성하라.
 */
package Exam_1002;

import java.util.Scanner;

interface IStack{
	int capacity();	//스택에 저장 가능한 개수 리턴
	int length();	//스택에 현재 저장된 개수 리턴
	boolean push(String val);	//스택의 톱에 문자열 저장하고 true 리턴
		//꽉 차서 넣을 수 없으면 false 리턴
	String pop();	//스택의 톱에 저장된 문자열 리턴, 스택이 비어 있으면 null 리턴
}
class StringStack implements IStack{
	private String[] stack;
	private int top = 0;
	public StringStack(int size) {
		stack = new String[size];
	}
	public int capacity() {
		return stack.length;
	}
	public int length() {
		return top;
	}
	public boolean push(String val) {
		if(top == stack.length) return false;	//스택 꽉참
		stack[top++] = val;
		return true;
	}
	public String pop() {
		if(top == 0) return null;
		return stack[--top];
	}
}
public class Exam_11 {
	public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
	System.out.print("스택 용량 >> ");
	int capa = scn.nextInt();
	scn.nextLine();//버퍼 비우기
	StringStack stack = new StringStack(capa);
	
	while(true) {
		System.out.print("문자열 입력 >>");
		String input = scn.nextLine();
		if(input.equals("그만")) break;
		
		if(!stack.push(input)) {
			System.out.println("스택이 꽉 찼습니다.");
		}
	}
	System.out.print("스택에 저장된 모든 문자열 팝 : ");
	while(stack.length()>0) {
		System.out.print(stack.pop()+" ");
	}
	
	scn.close();
	}
}
