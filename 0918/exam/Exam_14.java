package exam_0918;

import java.util.Scanner;

public class Exam_14 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int first, second, third;
        boolean tf=true;
        System.out.println("**** 갬블링 게임을 시작합니다 ****");
        
        while (tf) {
        	System.out.print("엔터키 입력 >> ");
        	String enter=scn.nextLine();
        	first = (int)(Math.random()*2);
        	second = (int)(Math.random()*2);
        	third = (int)(Math.random()*2);
        	System.out.println(first+"  "+second+"  "+third);
        	if(first==second&& second==third) {
        		System.out.println("성공! 대박났어요!");
        		System.out.print("계속하시겠습니까?(yes/no) >>");
        		enter = scn.nextLine();
        		if(enter.equals("no")) {
        			System.out.println("게임을 종료합니다.");
        			break;        			
        		}

        	}

        }
        scn.close();
    }
}
