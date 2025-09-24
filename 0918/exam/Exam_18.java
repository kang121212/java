/*
 * 실습문제 18
 * 1차원 정수 배열을 2개 생성하고 10명 학생의 학번과 점수를 입력받아 각각 저장하라. 
 * 그리고 다음과 같이 학번을 입력하면 점수를 출력하라.
 */
package exam_0918;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam_18 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] std = new int[10];     
        int[] score = new int[10];   

        System.out.println("10명 학생의 학번과 점수 입력");

        for (int i = 0; i < 10; i++) {
            while (true) {
                try {
                    System.out.print((i + 1) + " >> ");
                    int stdnum = scn.nextInt();
                    int stdscore = scn.nextInt();
                    std[i] = stdnum;
                    score[i] = stdscore;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("⚠️ 잘못된 입력입니다. 정수를 입력해주세요.");
                    scn.nextLine(); 
                }
            }
        }

        while (true) {
            try {
                System.out.print("학번으로 검색 : 1, 점수로 검색: 2, 끝내려면 3 >> ");
                int choice = scn.nextInt();

                if (choice == 1) {
                    System.out.print("학번 >> ");
                    int numsearch = scn.nextInt();
                    boolean found = false;
                    for (int i = 0; i < 10; i++) {
                        if (std[i] == numsearch) {
                            System.out.println("학번 " + std[i] + "의 점수는 " + score[i] + "점입니다.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ 해당 학번을 찾을 수 없습니다.");
                    }

                } else if (choice == 2) {
                    System.out.print("점수 >> ");
                    int scoresearch = scn.nextInt();
                    boolean found = false;
                    for (int i = 0; i < 10; i++) {
                        if (score[i] == scoresearch) {
                            System.out.println("점수 " + score[i] + "을 받은 학번은 " + std[i] + "입니다.");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("❌ 해당 점수를 받은 학생이 없습니다.");
                    }

                } else if (choice == 3) {
                    System.out.println("프로그램을 종료합니다.");
                    break;

                } else {
                    System.out.println("⚠️ 1, 2, 3 중에서 선택해주세요.");
                }

            } catch (InputMismatchException e) {
                System.out.println("⚠️ 잘못된 입력입니다. 숫자를 입력해주세요.");
                scn.nextLine(); 
            }
        }

        scn.close();
    }
}