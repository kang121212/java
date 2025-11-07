/*
 * 한 라인을 입력받아 각 문자열을 ArrayList<String>에 저장하고,
 * ArrayList에 중복된 문자열을 제거하여 중복된 문자열이 없는 상태로 만들라.
 * 그러고 나서 이를 출력하는 프로그램을 작성하라.
 */

package generic;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam_10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<>();
		
		System.out.println("한 줄의 문자열을 입력하세요");
		String line = scanner.nextLine();
		
		String[] tokens = line.split("\\s+");
		for(String token : tokens)
			words.add(token);
		
		ArrayList<String> uniqueWords = new ArrayList<>();
		for (String word : words) {
			if(!uniqueWords.contains(word))
				uniqueWords.add(word);
		}
		System.out.println("중복 제거 후 결과: ");
		for(String word : uniqueWords)
			System.out.print(word+" ");
		
		scanner.close();
	}
}


















