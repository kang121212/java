/* 연습문제 14
 * 배열은 정해진 크기 이상 저장할 수 없는 한계가 있다. 이 한계를 해소하는 가변 배열 클래스 VArray를 만들어 보자.
 * Varray는 생성자를 통해 전달받은 크기로 내부에 배열을 만든다. VArray는 배열 크기를 넘어 계속 저장되면 내부 배열의 크기를 2배로
 * 늘린다. VArray의 add()는 배열의 마지막 원소로 저장하며, insert()의 첫 번째 매개변수인 index 값은 현재 배열에 저장된 크기를 넘을 수 없다.
 * 독자들은 다음 main() 메소드를 가진 VArrayEx 클래스를 작성하고 실행 예시를 참고하여 VArray 클래스를 완성하라.
 */
package Exam_0925;

class VArray {
    private int[] arr;
    private int size;

    public VArray(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public int capacity() {
        return arr.length;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size >= arr.length) {
            expand();
        }
        arr[size++] = value;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("삽입 실패: 잘못된 인덱스입니다.");
            return;
        }
        if (size >= arr.length) {
            expand();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("삭제 실패: 잘못된 인덱스입니다.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void expand() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}

public class Exam_14 {
	public static void main(String[] args) {
		VArray v = new VArray(5);	//5개의 정수를 저장하는 가변 배열 객체 생성
		System.out.println("용량: "+v.capacity()+", 저장된 개수 : "+v.size());
		
		for(int i=0;i<7;i++)	//7개 저장
			v.add(i);	//배열에 순서대로 정수 i 값 저장
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+v.size());
		v.printAll();
		
		v.insert(3,100);	//배열의 인덱스 3에 100삽입
		v.insert(5,200);	//배열의 인덱스 5에 200삽입
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+v.size());
		v.printAll();
		
		v.remove(10);	//배열의 인덱스 10의 정수 삭제
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+v.size());
		v.printAll();
		
		for(int i=50; i<55; i++)	//5개 저장
			v.add(i);	//배열에 순서대로 정수 i 값 저장
		System.out.println("용량: "+v.capacity()+", 저장된 개수: "+v.size());
		v.printAll();
	}
}
