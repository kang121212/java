package basic;

import java.util.Scanner;

public class Project_2_9 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String std1, std2;
		int late1, late2, abs1, abs2;
		
		System.out.print("학생1>>");
		std1 = scn.next();
		late1 = scn.nextInt();
		abs1 = scn.nextInt();
		
		System.out.print("학생2>>");
		std2 = scn.next();
		late2 = scn.nextInt();
		abs2 = scn.nextInt();
		
		int minus1 = (3*late1)+(8*abs1);
		int minus2 = (3*late2)+(8*abs2);
		int total1 = 100-minus1;
		int total2 = 100-minus2;
		
		System.out.println(std1+"의 감점은 "+minus1+", "+std2+"의 감점은 "+minus2);
	
		
		if(total1>total2)
			System.out.println(std1+"의 출석 점수가 더 높음. "+std1+"의 출석 점수는 "+total1);
		else if(total1==total2)
			System.out.println("점수 동일");
		else
			System.out.println(std2+"의 출석 점수가 더 높음. "+std2+"의 출석 점수는 "+total2);
		
		
		scn.close();
	}
}
