/* 연습문제 10
 * BaseArray를 상속받아 값이 큰 순서로 배열을 항상 유지하는 SortedArray를 작성하라.
 * 다음 main() 메소드를 포함하고 실행 결과와 같이 출력되게 하라.
 */
package Exam_1002;

import java.util.Scanner;

class BaseArray1{
	protected int array [];	//배열 메모리
	protected int nextIndex = 0;	//다음에 삽입할 배열에 대한 인덱스
	public BaseArray1(int size) {
		array = new int [size];
	}
	public int length() { return array.length;}
	public void add(int n) {	//정수 n을 배열 끝에 추가
		if(nextIndex == array.length) return;	//배열이 꽉 찼으면 추가 안 함
		array[nextIndex] = n;
		nextIndex++;
	}
	public void print() {
		for(int n : array) System.out.print(n+" ");
		System.out.println();
	}
}

class SortedArray extends BaseArray1{
	public SortedArray(int size) {
		super(size);
	}
	public void add(int n) {
		if(nextIndex==array.length) return;
		int i = nextIndex -1;
		while(i>=0 && array[i] > n) {
			array[i+1] = array[i];	//오른족으로 이동
			i--;
		}
		array[i+1] = n;
		nextIndex++;
	}
}

public class Exam_10 {
	public static void main(String[] args) {
		SortedArray sArray = new SortedArray(10);
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		for(int i=0; i<sArray.length(); i++) {
			int n = scanner.nextInt();
			//sArray.length()는 10
			sArray.add(n);
		}
		sArray.print();
		scanner.close();
	}
}
