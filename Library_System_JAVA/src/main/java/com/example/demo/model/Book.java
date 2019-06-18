package com.example.demo.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "BookTable")
public class Book{

	//Mainigie
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_b")
	private int id_b;
	
	@NotNull
	@Column(name = "ISBN" )
	private String isbn;
	
	@NotNull
	@Column(name = "Year" )
	private int year;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "Title")
	private String title;
	
	@NotNull
	@Size(min = 4, max =26)
	@Column(name = "Author")
	private String author;
	
	@Column(name = "Rating")
	private double rating;
	
	@NotNull
	@Column(name = "Condition")
	private String condition;	//good, bad, perfect
	
	@NotNull
	@Column(name = "Rarity")
	private int rarity;
	
	@NotNull
	@Size(min = 10, max = 200)
	@Column(name = "Anotation")
	private String anotation;
	
	@Column(name = "TimesTaken")
	private int timesTaken;
	
	@NotNull
	@Column(name = "Coppies")
	private int coppies;
	
	@ManyToOne
	@JoinColumn(name = "Id_dp")
	private LibraryDepartment department;
	
	@ManyToOne
	@JoinColumn(name = "Id_r")
	private Reader reader;
	
	
	//Konstruktori
	
	public Book() {
		coppies++;
		timesTaken = 0;
	}

	
	public Book(String isbn, int year, String title, String author, double rating, String condition, int rarity, String anotation, LibraryDepartment department) {
		setIsbn(isbn);
		setYear(year);
		setTitle(title);
		setAuthor(author);
		setRating(rating);
		setCondition(condition);
		setRarity(rarity);
		setAnotation(anotation);
		setDepartment(department);
		coppies++;
		timesTaken = 0;
	}
	
	public Book(String isbn, int year, String title, String author, double rating, String condition, int rarity, String anotation) {
		setIsbn(isbn);
		setYear(year);
		setTitle(title);
		setAuthor(author);
		setRating(rating);
		setCondition(condition);
		setRarity(rarity);
		setAnotation(anotation);
		coppies++;
		timesTaken = 0;
	}
	
	
	
	//Set un get
	
	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		String isbnTemp = "";
		if(isbn.length() != 10) {
			this.isbn = "1111111111";
		}
		else {
			for (int i = 0; i < isbn.length(); i++) {
				if(Character.isDigit(isbn.charAt(i))){
					isbnTemp += isbn.charAt(i);
				}
			}
			if(isbnTemp.length() != 10) {
				this.isbn = "1111111111";
			}
			else {
				this.isbn = isbnTemp;
			}
		}
	}


	public int getYear() {
		return year;
	}

	
	public void setYear(int year) {
		if(year > 1750 && year <= 2019)
			this.year = year;
		else
			this.year = 2019;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		String tempTitle = "";
		if(title.length() != 0) {
			for (int i = 0; i < title.length(); i++) {
				if(Character.isLetter(title.charAt(i)) || Character.isSpaceChar(title.charAt(i))){
					tempTitle += title.charAt(i);
				}
			}
			this.title = tempTitle;
		}
		else {
			this.title = "The book";
		}
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		String authorTemp = "";
		if(author.length() != 0) {
			for (int i = 0; i < author.length(); i++) {
				if(Character.isLetter(author.charAt(i)) || Character.isSpaceChar(author.charAt(i))){
					authorTemp += author.charAt(i);
				}
			}
			this.author = authorTemp;
		}
		else {
			this.author = "Janis Berzins";
		}
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		if(rating >= 0 && rating <= 5) {
			this.rating = rating;
		}
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		String conditionTemp = "";
		if(condition.length() != 0) {
			for (int i = 0; i < condition.length(); i++) {
				if(Character.isLetter(condition.charAt(i))){
					conditionTemp += condition.charAt(i);
				}
			}
			this.condition = conditionTemp;
		}
		else {
			this.condition = "Good";
		}
	}


	public int getRarity() {
		return rarity;
	}


	public void setRarity(int rarity) {
		if(rarity >= 1 && rarity <= 5)
			this.rarity = rarity;
		else 
			this.rarity = 1;
	}

	public String getAnotation() {
		return anotation;
	}


	public void setAnotation(String anotation) {
		this.anotation = anotation;
	}
	
		public LibraryDepartment getDepartment() {
		return department;
	}


	public void setDepartment(LibraryDepartment department) {
		this.department = department;
	}
	
	
	public int getTimesTaken() {
		return timesTaken;
	}
	
	public int getCoppies() {
		return coppies;
	}

	public int getId_b() {
		return id_b;
	}

	public boolean takeBook() {
		if(isAvailable()) {
			this.timesTaken ++;
			this.coppies --;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void returnBook() {
		this.coppies ++;
	}

	public boolean isAvailable() {
		return (coppies > 0) ? true : false;
	}
	
	public boolean addCopy() {
		if(coppies < 5) {
			this.coppies++;
			return true;
		}
		else 
			return false;
	}
	
	
	
	
	//To string

	public void setTimesTaken(int timesTaken) {
		this.timesTaken = timesTaken;
	}


	@Override
	public String toString() {
		return "Book isbn: " + isbn + ", year: " + year + ", title: " + title + ", author: " + author + ", rating: " + rating + ", condition: " + condition + ", rarity: " + rarity;
	}

	
}
