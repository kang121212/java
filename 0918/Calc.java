package array;

public class Calc {

	public static void main(String[] args) {
		double sum = 0.0;
		
		for (int i=0; i<args.length; i++) //인자 개수만큼 반복
			sum+= Double.parseDouble(args[i]);
		//문자열을 실수(double 타입)으로 변환
		System.out.println("합계 = "+sum);

	}

}
