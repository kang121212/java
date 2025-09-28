/*
 * 실습문제 4
 * 다음 main() 메소드는 Average 클래스를 이용하여 정수를 저장하고 평균을 
 * 구하여 출력한다. 이 코드와 실행 결과를 참고하여 Average 클래스 작성하라.
 * Average 클래스는 최대 10개까지만 정수를 저장할 수 있다.
 */
package Exam_0925;

class Average{
	private int n[] = new int[10];
	private int nextIndex=0;
	
	public Average() {
		for(int i=0; i<n.length; i++) {
			this.n[i]=n[i];
		}
	}
	public void put(int a) {
		n[nextIndex]=a;
		nextIndex ++;
	}
	public void showAll() {
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(n[i]);
            if (i < nextIndex - 1) System.out.print(", ");
        }
        System.out.println();
    }

	public double getAvg() {
		double sum=0;
		for(int i=0; i<nextIndex; i++) {
			sum += n[i];
		}
		return (double)sum/nextIndex;
	}
}

public class Exam_4 {
	public static void main(String[] args) {
		Average avg = new Average();
		System.out.println("****** 저장된 데이터 모두 출력 *******");
		avg.put(10);	//10 저장
		avg.put(15);	//15 저장
		avg.put(100);	//100 저장
		avg.showAll();	//저장된 모든 원소 출력
		System.out.print("평균은 "+avg.getAvg());	//평균 출력
	}
}
