package exam_0918;

public class Exam_2 {

	public static void main(String[] args) {
		int n[]= {1,-2,6,20,5,72,-16,256};
		int i = 0;
		do {
			if(n[i] > 0 && n[i] % 4 ==0)
				System.out.print(n[i] + " ");
			i++;
		} while(i<n.length);
		
		
		
		/*int i = 0;
		while(i<n.length) {
			if(n[i] > 0 && n[i] % 4 ==0)
				System.out.print(n[i] + " ");
			i++;
		}*/
		
		
		/*
		 * for(int i=0; i<n.length; i++) {
			if(n[i] > 0 && n[i] % 4 == 0) {
				System.out.print(n[i] + " ");
			}
		}
		*/
	}
}
/*
 * 1.무엇을 계산하는 코드인가? 배열i에서 4의 배수인 양의 정수값을 구하는 코드입니다.
 * 1.실행결과 출력되는 내용은? 20 72 256
 * */
