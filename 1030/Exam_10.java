/*
 * 실습문제 10
 * 5~9개의 글자로 이루어진 여러개의 단어를 프로그램 내 String 배열에 미리 저장하라. 
 * 예를 들어 "Happy", "morning", "package", "together" 등이며 단어의 개수는 독자들이 알아서 하라.
 * 이 던어 중에서 1개를 선택하여 단어의 글자 순서를 바꾸어 출력하면 사용자가 10초 내로 맞추는 문제이다.
 * (1) 실행 결과가 (a)와 같도록 프로그램을 작성하라.경과 시간은 시계로 측정한다.
 * 10초 안에 단어 맞추기
 * 그만 이라고 입력시 멈춤
 */

package appl;

import java.util.Random;
import java.util.Scanner;

public class Exam_10 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Random rand = new Random();
		
		String[] words = {"happy", "morning", "package", "together"};
		System.out.println("10초 안에 단어를 맞추세요!!");
		
		while(true) {
			String original = words[rand.nextInt(words.length)];
			String shuffled = shuffleWord(original, rand);
			
			System.out.println(shuffled);
			System.out.print(">>");
			
			long start = System.currentTimeMillis();
			String answer = scn.nextLine();
			long end = System.currentTimeMillis();
			
			if(answer.equalsIgnoreCase("그만")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			long elapsed = (end - start) / 1000;
			
			if(elapsed >10) {
				System.out.println("시간 초과! [" +elapsed + "초]");
			}else if(answer.equalsIgnoreCase(original)) {
				System.out.println("정답입니다. ["+ elapsed + "초]");
			}else {
				System.out.println("오답입니다. 정답은 "+original+" 입니다.");
			}
		}
		scn.close();
	}
	
	public static String shuffleWord(String word, Random rand) {
		char[] chars = word.toCharArray();
		for(int i = 0; i<chars.length; i++) {
			int j = rand.nextInt(chars.length);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}
	
}
