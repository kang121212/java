/*
 * 오픈 챌린지
 * 영문자 히스토그램 만들기
 * 텍스트를 키보드로 입력받아 알파벳이 아닌 문자는 제외하고 영문자 히스토그램을 만들어보자. 대문자와 소문자는 모두 같은 것으로 간주하고, 세미콜론(;)만 있는 라인을 만나면 입력의 끝으로 해석한다.
 */

package appl;

import java.util.Scanner;

public class Prcatice{
	static String readString() {
		StringBuffer sb = new StringBuffer();	// 키 입력을 받을 스트링버퍼 생성
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine();	//텍스트 한 라인을 읽는다.
			if(line.equals(";"))	//;만 있는 라인이면
				break;
			sb.append(line);	//읽은 라인 문자열을 스트링버퍼에 추가한다.
		}
		scanner.close();
		return sb.toString();	//스트링버퍼의 문자열을 스트링으로 리턴
		
	}
	
	public static void main(String[] args) {
		String input = readString();
		int [] counts = new int [26];	//A-Z까지 26개 알파벳 카운트
		
		for (int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isLetter(ch)) {
				ch = Character.toUpperCase(ch);	//대소문자 통일
				counts[ch - 'A']++;	//해당 알파벳 카운트 증가
			}
		}
		//히스토그램 출력
		System.out.println("히스토그램을 그립니다.");
		for(int i=0; i<counts.length; i++) {
			char letter = (char) ('A' + i);
			if(counts[i]>0) {
				System.out.print(letter);
				for(int j=0; j<counts[i]; j++) {
					System.out.print("-");
				}
				System.out.println();
			}
			
		}
		
	}
	
}
