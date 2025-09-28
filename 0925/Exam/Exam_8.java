/* 연습문제 8
 * Account 클래스는 1개의 은행 계좌를 나타낸다. 실행 결과와 같이 출력되도록 Account 클래스를 작성하라.
 * 잔금이 인출하는 금액보다 작으면, 잔금만큼만 인출된다.
 */

package Exam_0925;

class Account{
	private int balance;
	
	public Account(int balance) {
		this.balance=balance;
	}
	public void deposit(int amount) {
			balance+=amount;
	}
	public void deposit(int[] depo) {
		for(int i=0; i<depo.length;i++) {
			balance+=depo[i];
		}
	}
	public int getBalance() {
		return balance;
	}
	public int withdraw(int with) {
		if(balance>=with) {
			balance -= with;
			return with;
		}
		else {
			balance=0;
			return balance;
		}
	}
}

public class Exam_8 {
	public static void main(String[] args) {
		Account a = new Account(100);
		a.deposit(5000);	//5000원 예금
		System.out.println("잔금은 "+a.getBalance()+"원입니다.");
		
		int bulk[] = {100, 500, 200, 700};
		a.deposit(bulk);	//bulk 배열에 있는 모든 돈 예금
		System.out.println("잔금은 "+a.getBalance()+"원입니다.");
		
		int money = 1000;
		int wMoney = a.withdraw(money);	//1000원 인출 시도. wMoney는 실제 인출한 금액
		if(wMoney < money)
			System.out.println(wMoney+"원만 인출");	//잔금이 1000원 보다 작은 경우
		else
			System.out.println(wMoney+"원 인출");	// 잔금이 1000원 보다 큰 경우
		System.out.println("잔금은"+a.getBalance()+"원 입니다.");
		
	}
	
}
