/*
 * 실습문제 14
 * 갬블링 게임 프로그램을 작성해보자. 사용자가 엔터키를 입력하면 0 1 2 중에서 랜덤하게
 * 3개의 수를 생성하여 출력하고, 3개가 모두 같은 값일 때 "성공, 대박났어요."를 출력한다.
 * 실행 예시를 참고하여 프로그램을 작성하라.
 */
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
