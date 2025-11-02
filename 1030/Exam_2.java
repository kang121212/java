/*
 * 실습문제 2
 * 저자, 도서명, 구입자 이름의 3개의 필드를 가지는 Book 클래스를 작성하라.
 * 생성자는 저자, 도서명, 구입자를 매개변수로 전달받아 해당 필드를 초기화하고, equals() 메소드는 
 * 두 Book 객체의 저자와 도서명만 같으면 같은 것으로 판별하도록 한다. Book 클래스와 함께 다음
 * 실행 예시와 같이 main()에서 Book 객체를 활용하는 BookApp클래스를 작성하라.
 */

package appl;

class Book{
	private String writer, title, buyer;
	
	public Book(String writer, String title, String buyer) {
		this.writer = writer;
		this.title = title;
		this.buyer = buyer;
	}
	
	public String toString() {
		return buyer+"이 구입한 도서: "+writer+"의 "+title;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book other = (Book) obj;
			return this.writer.equals(other.writer)&& this.title.equals(other.title);
		}
		return false;
	}
}

public class Exam_2 {
	public static void main(String[] args) {
		Book a = new Book("황기태", "명품자바", "김하진");
		Book b = new Book("황기태", "명품자바", "하여린");
		System.out.println(a);
		System.out.println(b);
		if(a.equals(b))
			System.out.println("같은 책");
		else
			System.out.println("다른 책");
	}
}
