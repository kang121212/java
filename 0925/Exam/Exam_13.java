/* 연습문제 13
 * 간단한 콘서트 예약 시스템을 만들어 보자. 다수의 클래스르 다루고 객체의 배열을 
 * 다루기에는 아직 자바 프로그램 개발이 익숙하지 않은 초보자에게 다소 무리가 있을 것이다.
 * 그러나 반드시 넘어야 할 산이다. 이 도전을 통해 산을 넘어갈 수 있는 체력을 키워보자.
 * 예약 시스템의 기능은 다음과 같다.
 * - 공연은 하루에 한 번 있다.
 * - 좌석은 S석, A석, B석으로 나뉘며, 각각 10개의 좌석이 있다.
 * - 예약 시스템의 메뉴는 "예약", "조회","취소","끝내기"가 있다.
 * - 예약은 한자리만 가능하고, 좌석타입, 예약자 이름, 좌석번호를 순서대로 입력받아 예약한다.
 * - 조회는 모든 좌석을 출력한다.
 * - 취소는 예약자의 이름을 입력받아 취소한다.
 * - 없는 이름, 없는 번호, 없는 메뉴, 잘못된 취소 등에 대해서 오류 메세지를 출력하고 
 * 사용자가 다시 시도하도록 한다.
 */
package Exam_0925;

import java.util.Scanner;

class Seat {
    private String name;

    public Seat() {
        this.name = "---"; // 빈 좌석 표시
    }

    public boolean isEmpty() {
        return name.equals("---");
    }

    public void reserve(String name) {
        this.name = name;
    }

    public void cancel() {
        this.name = "---";
    }

    public String getName() {
        return name;
    }
}

class SeatGroup {
    private String type;
    private Seat[] seats;

    public SeatGroup(String type) {
        this.type = type;
        seats = new Seat[10];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat();
        }
    }

    public void show() {
        System.out.print(type + "석 >> ");
        for (Seat seat : seats) {
            System.out.print(seat.getName() + " ");
        }
        System.out.println();
    }

    public boolean reserve(int seatNum, String name) {
        if (seatNum < 1 || seatNum > 10) return false;
        if (!seats[seatNum - 1].isEmpty()) return false;
        seats[seatNum - 1].reserve(name);
        return true;
    }

    public boolean cancel(String name) {
        for (Seat seat : seats) {
            if (seat.getName().equals(name)) {
                seat.cancel();
                return true;
            }
        }
        return false;
    }
}

class ConcertReservationSystem {
    private SeatGroup[] groups;
    private Scanner scn;

    public ConcertReservationSystem() {
        groups = new SeatGroup[3];
        groups[0] = new SeatGroup("S");
        groups[1] = new SeatGroup("A");
        groups[2] = new SeatGroup("B");
        scn = new Scanner(System.in);
    }

    private int getGroupIndex(String type) {
        switch (type.toUpperCase()) {
            case "S": case "1": return 0;
            case "A": case "2": return 1;
            case "B": case "3": return 2;
            default: return -1;
        }
    }


    public void reserve() {
        System.out.print("좌석 종류 S(1), A(2), B(3) >> ");
        String type = scn.next();
        int idx = getGroupIndex(type);
        if (idx == -1) {
            System.out.println("잘못된 좌석 종류입니다.");
            return;
        }
        groups[idx].show();
        System.out.print("예약자 이름 >> ");
        String name = scn.next();
        System.out.print("좌석 번호(1~10) >> ");
        int seatNum = scn.nextInt();
        if (groups[idx].reserve(seatNum, name))
            System.out.println("예약 완료!");
        else
            System.out.println("예약 실패! 이미 예약되었거나 번호가 잘못되었습니다.");
    }

    public void view() {
        for (SeatGroup group : groups) {
            group.show();
        }
    }

    public void cancel() {
        System.out.print("좌석 종류 S(1), A(2), B(3) >> ");
        String type = scn.next();
        int idx = getGroupIndex(type);
        if (idx == -1) {
            System.out.println("잘못된 좌석 종류입니다.");
            return;
        }
        groups[idx].show();
        System.out.print("취소할 예약자 이름 >> ");
        String name = scn.next();
        if (groups[idx].cancel(name))
            System.out.println("취소 완료!");
        else
            System.out.println("취소 실패! 해당 이름의 예약이 없습니다.");
    }

    public void run() {
        System.out.println("콘서트 예약 시스템입니다.");
        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
            int cmd = scn.nextInt();
            switch (cmd) {
                case 1: reserve(); break;
                case 2: view(); break;
                case 3: cancel(); break;
                case 4: System.out.println("시스템을 종료합니다."); return;
                default: System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}

public class Exam_13 {
    public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
        ConcertReservationSystem system = new ConcertReservationSystem();
        system.run();
        scn.close();
    }
}