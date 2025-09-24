/*
 * 실습문제 1
 * 다음 프로그램에 대해 물음에 답하라.
 */
/* 1. 무엇을 계산하는 코드인가? 1부터 50까지의 수 중에서 3씩 더해서 나오는 값들을 모두 더하는 문제이다.
 * 실행 결과 출력되는 내용은? 425
 */
package exam_0918;

public class Exam_1 {

	public static void main(String[] args) {
		int i=1, sum=0;
		do {
			sum=sum+i;
			i+=3;
		} while(i<=50);
			
		/* int sum =0;
		for(int i =1; i <=50; i=i+3) {
			sum=sum+i;
		}
		
		int sum=0, i=1;
		while (true) {
			if(i>50)
				break;
			sum=sum+i;
			i+=3;
		}*/
		System.out.println(sum); 
	}
}
