package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ReaderTable")
public class Reader{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_r")
	private int id_r;
	private String name;
	private String surname;
	private ArrayList <Book> currentTakenBookList;
	
	
	public Reader(){
		
	}
	
	public Reader(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String nameTmp = "";
		for (int i = 0; i < name.length(); i++) {
			if(Character.isLetter(name.charAt(i))){
				nameTmp += name.charAt(i);
			}
		}
		this.name = nameTmp;
	}
	
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		String surnameTmp = "";
		for (int i = 0; i < surname.length(); i++) {
			if(Character.isLetter(surname.charAt(i))){
				surnameTmp += surname.charAt(i);
			}
		}
		this.surname = surnameTmp;
	}
	
	public ArrayList<Book> getCurrentTakenBookList() {
		return currentTakenBookList;
	}
	
	public void takeABook(Book book) {
		this.currentTakenBookList.add(book);
	}
	
	
}
