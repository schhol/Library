package com.example.demo.model;

import java.util.ArrayList;
import java.util.Calendar;

public class LibraryDepartment {
	
	private ArrayList <Book> booklist;
	private String specialization;
	private ArrayList <Employee> allEmployees;
	private ArrayList <Calendar> workingtimes;
	private ArrayList <Book> bookQueForFutureCheckout;
	
	//chemestry, mathematics, physics, business, IT, languages, poetry
	
	
	public boolean giveBook(Book gBook) {
		return true;
	}
	
	public boolean takeBook(Book tBook) {
		return true;
	}
	
	public void addBook(Book newBook) {
		
	}
	
	public boolean removeBook() {
		return true;
	}
	
	
	
}
