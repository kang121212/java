/* 연습문제 11
 * 다음 2개의 static 속성을 가진 ArrayUtil 클래스를 만들어 보자.
 * 다음 코드와 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하라.
 */
package Exam_0925;

class ArrayUtil {
    public static int[] concat(int[] a, int[] b) {
        // 배열 a와 b를 연결한 새로운 배열 리턴
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        return result;
    }

    public static void print(int[] a) {
        // 배열 a 출력
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");
    }
}

public class Exam_10 {
	public static void main(String[] args) {
		int [] array1 = {1,5,7,9};
		int [] array2 = {3,6,-1,100,77};
		int [] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}
}
