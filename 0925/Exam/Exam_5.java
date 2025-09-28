/*
 * 실습문제 5
 * 노래 한 곡을 나타내는 Song 클래스를 작성하라. 
 * Song 클래스의 필드들은 다음과 같다.
 * 노래의 제목 title/가수 이름 singer /발표 년도 year /가수 나라 lang
 * 또한 Song 클래스에는 다음 메소드들이 있고, main()의 실행 결과는 다음과 같다.
 * -노래 제목, 가수 이름, 발표 년도, 가수 나라 등 4개의 매개변수를 받아
 * 객체의 각 필드를 초기화하는 생성자
 * - 노래 정보를 출력하는 show() 메소드
 * - main() 메소드는 "가로수 그늘 아래 서면", "이문세", 1988, "한국"을
 * 매개변수로 하여 Song 객체로 생성하고, 이 객체의 show()를 호출하여 노래 정보를
 * 다음과 같이 출력한다.
 */

package Exam_0925;

class Song{
	private String title;
	private String singer;
	private int year;
	private String lang;
	
	public Song(String title, String singer, int year, String lang) {
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.lang = lang;
	}
	public void show() {
		System.out.println(year+"년 "+lang+"의 "+singer+"씨가 부른 "+title);
	}
}

public class Exam_5 {
	public static void main(String[] args) {
		String title = "가로수 그늘 아래 서면";
		String singer = "이문세";
		int year = 1988;
		String lang = "한국";
		Song info = new Song(title,singer,year,lang);
		info.show();
	}
}
