/*
 * 실습문제 17
 * 다음과 같이 커피와 가격을 각가 배열로 만들고, 
 * 이를 활용하여 실행 사례와 같이 주문을 받아 가격을 계산하는 프로그램을 작성하라.
 */
package exam_0918;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam_17 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};

        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");
        System.out.println("주문을 종료하려면 '그만'이라고 입력하세요.");

        while (true) {
            try {
                System.out.print("주문 >> ");
                String menu = scn.next();

                if (menu.equals("그만")) {
                    System.out.println("주문을 종료합니다.");
                    break;
                }

                int many = scn.nextInt();

                boolean found = false;
                for (int i = 0; i < coffee.length; i++) {
                    if (coffee[i].equals(menu)) {
                        int total = price[i] * many;
                        System.out.println(menu + " " + many + "잔의 가격은 " + total + "원입니다.");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("해당 메뉴는 없습니다. 다시 입력해주세요.");
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 수량은 숫자로 입력해주세요.");
                scn.nextLine(); 
            }
        }

        scn.close();
    }
}