/*
 * 오픈 챌린지
 * 영어 단어 뜻 맞추기 게임을 만들어 보자. 영어 단어와 한글 단어로 구성되는 Word 클래스를 작성하고, 프로그램 내에서 미리 여러 개의 Word 객체를 Vector<Word> 컬렉션에 삽입해둔다.
 * 그리고 다음 결과와 같이 랜덤하게 사용자에게 문제를 던진다. 벡터 내에 정답이 아닌 단어를 랜덤하게 3개 선택하고 정답과 함께 4개의 보기를 출력한다.
 * 
 */

package generic;

import java.util.*;

class Word{
	private String english;
	private String korean;
	
	public Word(String english, String korean) {
		this.english = english;
		this.korean = korean;
	}
	public String getEnglish() {
		return english;
	}
	public String getKorean() {
		return korean;
	}
}

public class OpenChallenge {
	private Vector<Word> wordList = new Vector<>();
	private Scanner scanner = new Scanner(System.in);
	private Random random = new Random();
	
	public OpenChallenge() {
		wordList.add(new Word("apple", "사과"));
		wordList.add(new Word("banana", "바나나"));
		wordList.add(new Word("computer", "컴퓨터"));
		wordList.add(new Word("school", "학교"));
		wordList.add(new Word("book", "책"));
		wordList.add(new Word("water", "물"));
		wordList.add(new Word("sun", "태양"));
		wordList.add(new Word("moon", "달"));
	}
	public void run() {
		System.out.println("영어 단어 뜻 맞추기 게임을 시작합니다.");
		while(true) {
			int answerIndex = random.nextInt(wordList.size());
			Word answer = wordList.get(answerIndex);
			
			Set<Integer> options = new HashSet<>();
			options.add(answerIndex);
			
			while(options.size()<4) {
				int randIndex = random.nextInt(wordList.size());
				if(randIndex != answerIndex) {
					options.add(randIndex);
				}
			}
			
			List<Integer> optionList = new ArrayList<>(options);
			Collections.shuffle(optionList);
			
			System.out.println("\n" + answer.getEnglish() + "의 뜻은 무엇일까요?");
			for(int i = 0; i < optionList.size(); i++) {
				System.out.println((i+1)+": "+wordList.get(optionList.get(i)).getKorean());
			}
			
			System.out.print("번호를 입력하세요(종료 : 0)");
			int userChoice = scanner.nextInt();
			if(userChoice == 0) {
				System.out.println("게임 종료");
				break;
			}
			
			int chosenIndex = optionList.get(userChoice -1);
			if(chosenIndex == answerIndex) {
				System.out.println("정답입니다.");
			} else {
				System.out.println("틀렸습니다. 정답은 "+answer.getKorean()+ "입니다.");
				
			}
		}
	}
	
	public static void main(String[] args) {
		OpenChallenge game = new OpenChallenge();
		game.run();
	}
}




















