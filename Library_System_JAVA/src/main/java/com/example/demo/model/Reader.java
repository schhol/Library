package com.example.demo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ReaderTable")
public class Reader{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_r")
	private int id_r;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "Surname")
	private String surname;
	
	@Column(name = "BookList")
	private ArrayList <Book> currentTakenBookList;
	
	@OneToOne
	@JoinColumn(name = "Id_u")
	private User userRead;
	
	
	//Konstruktori
	
	public Reader(){
		
	}
	
	public Reader(@NotNull @Size(min = 3, max = 15) String name, @NotNull @Size(min = 3, max = 15) String surname) {
		setName(name);
		setSurname(surname);
	}
	
	
	
	//set un get
	
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

	public User getUserRead() {
		return userRead;
	}

	public void setUserRead(User userRead) {
		this.userRead = userRead;
	}

	public int getId_r() {
		return id_r;
	}

	
	
	//to string
	
	@Override
	public String toString() {
		return "ID: " + id_r + ", name: " + name + ", surname: " + surname + ", currentTakenBookList: " + currentTakenBookList;
	}
	
	
	
	
	
	
}
