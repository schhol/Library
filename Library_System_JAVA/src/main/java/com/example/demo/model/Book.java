package com.example.demo.model;

import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BookTable")
public class Book {

	//Mainigie
	//Baigais galax
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_b")
	private int id_b;
	
	@NotNull
	@Size(min = 10, max = 10)
	@Column(name = "ISBN")
	private int[] isbn;
	
	private Calendar year;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "Title")
	private String title;
	
	@NotNull
	@Size(min = 8, max =26)
	@Column(name = "Author")
	private String author;
	
	@NotNull
	@Size(min = 4, max = 10)
	@Column(name = "Rating")
	private float rating;
	
	@NotNull
	@Size(min = 4, max = 10)
	@Column(name = "Condition")
	private String condition;	//good, bad, perfect
	
	@NotNull
	@Size(min = 4, max = 10)
	@Column(name = "Rarity")
	private String rarity;		//common, rare, veryRare 
	
	@NotNull
	@Size(min = 10, max = 200)
	@Column(name = "Anotation")
	private String anotation;
	
	@ManyToOne
	@JoinColumn(name = "Id_dp")
	private LibraryDepartment department;
	
	
	//Konstruktori
	
	public Book() {
	}

	
	public Book(int[] isbn, Calendar year, String title, String author, float rating, String condition, String rarity, String anotation) {
		super();
		setIsbn(isbn);
		setYear(year);
		setTitle(title);
		setAuthor(author);
		setRating(rating);
		setCondition(condition);
		setRarity(rarity);
		setAnotation(anotation);
	}
	
	
	
	
	//Set un get
	
	public int[] getIsbn() {
		return isbn;
	}


	public void setIsbn(int[] isbn) {
		int[] temp = new int[10];
		for (int i = 0; i < isbn.length; i++) {
			if(isbn[i] >= 0) {
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


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getRarity() {
		return rarity;
	}


	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getAnotation() {
		return anotation;
	}


	public void setAnotation(String anotation) {
		this.anotation = anotation;
	}
	
	
	
	//To string


	@Override
	public String toString() {
		return "Book isbn: " + Arrays.toString(isbn) + ", year: " + year + ", title: " + title + ", author: " + author + ", rating: " + rating + ", condition: " + condition + ", rarity: " + rarity;
	}

	
	
	
	
	
}
