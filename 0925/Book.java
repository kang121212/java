package Intro;

public class Book {
	String title, author;
	public Book(String t) {
		title = t;
		author = "작가미상";
	}
	public Book(String t, String author) {
		title = t;
		this.author = author;
	}
	
	public static void main(String[] args) {
		Book littleprince = new Book("어린왕자", "생떼쥐베리");
		Book loveStory = new Book("춘향전");
		System.out.println(littleprince.author + " " + littleprince.title);
		System.out.println(loveStory.author + " " + loveStory.title);
	}
}
