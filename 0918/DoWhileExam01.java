package control;

public class DoWhileExam01 {

	public static void main(String[] args) {
		char c = 'a';			// 'a' = 61h, 97
								// 'A' = 41h, 65     
		do {					// 32를 빼주면 소문자다
			System.out.print(c);
			c = (char)(c + 1);	//정수 4바이트라서 캐스팅
		} while (c <= 'z');		//char은 8바이트

	}

}
