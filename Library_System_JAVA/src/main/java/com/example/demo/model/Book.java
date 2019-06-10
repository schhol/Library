package model;

import java.util.Arrays;
import java.util.Calendar;

public class Book {

	//Mainigie
	
	private int[] isbn;
	private Calendar year;
	private String title;
	private String author;
	private float rating;
	private BookCondition condition;
	private BookRarity rarity;
	private String anotation;
	
	
	
	//Konstruktori
	
	public Book() {
		super();
	}

	
	public Book(int[] isbn, Calendar year, String title, String author, float rating, BookCondition condition, BookRarity rarity) {
		super();
		this.isbn = isbn;
		this.year = year;
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.condition = condition;
		this.rarity = rarity;
	}
	
	
	
	
	//Set un get
	
	public int[] getIsbn() {
		return isbn;
	}


	public void setIsnb(int[] isbn) {
		int[] temp = new int[10];
		for (int i = 0; i < isbn.length; i++) {
			if(isbn[i] <= 0) {
				temp[i] = isbn[i];
			}
		}
		
		this.isbn = temp;
	}


	public Calendar getYear() {
		return year;
	}

	
	public void setYear(Calendar year) {
		this.year = year;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		String tempTitle = "";
		for (int i = 0; i < title.length(); i++) {
			if(Character.isLetter(title.charAt(i))){
				tempTitle += title.charAt(i);
			}
		}
		this.title = tempTitle;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		if(rating >= 0 && rating <= 5) {
			this.rating = rating;
		}
	}


	public BookCondition getCondition() {
		return condition;
	}


	public void setCondition(BookCondition condition) {
		this.condition = condition;
	}


	public BookRarity getRarity() {
		return rarity;
	}


	public void setRarity(BookRarity rarity) {
		this.rarity = rarity;
	}

	
	
	//To string

	@Override
	public String toString() {
		return "Book isbn: " + Arrays.toString(isbn) + ", year: " + year + ", title: " + title + ", author: " + author + ", rating: " + rating + ", condition: " + condition + ", rarity: " + rarity;
	}

	
	
	
	
	
}
