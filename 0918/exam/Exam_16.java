package exam_0918;

import java.util.Scanner;

public class Exam_16 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.print("양의 정수를 입력하세요. (-1은 입력 끝) >> ");
		String line = scn.nextLine();
		String[] tokens = line.split(" ");
		int sum =0;
		int count =0;
		for(String token : tokens) {
			try {
				int num=Integer.parseInt(token);
				if(num==-1) 
					break;
				else if(num>0) {
					sum+=num;
					count++;
				} else 
					System.out.println(token+" 제외");
			} catch (NumberFormatException e) {
				System.out.println(token + " 제외");
			}
		}
		
		if (count>0) {
			double average = (double) sum / count;
			System.out.println("평균은 "+(int)average);
		} else {
			System.out.println("양의 정수가 입력되지 않았습니다.");
		}
		scn.close();
	}

}
