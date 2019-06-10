package com.example.demo.model;


public class Person {
	
	//Mainigie
	
	private String name;
	private String surname;
	
	//sita klase nevajadzes
	
	//Konstruktori
	
	public Person() {
	}
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
	

	//Set un get
	
	public String getName() {
		return name;
	}

	/**
	 * @param name Personas vards
	 * nameTmp pagaidu string mainigais, kura glabas derigos simbolus
	 * 
	 * Parbauda parametra name katru simbolu - ja burts, tad ieliek mainigajaa nameTmp
	 * Objekta mainigajam name pieskir nameTmp
	 * 
	 */
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
	
	/**
	 * @param surname - Personas uzvards
	 * surnameTmp - Pagaidu string mainigais, kura glabas derigos simbolus
	 * 
	 * Parbauda parametra surname katru simbolu - ja burts, tad ieliek mainigajaa surnameTmp
	 * Objekta mainigajam surname pieskir surnameTmp
	 * 
	 */
	public void setSurname(String surname) {
		String surnameTmp = "";
		for (int i = 0; i < surname.length(); i++) {
			if(Character.isLetter(surname.charAt(i))){
				surnameTmp += surname.charAt(i);
			}
		}
		this.surname = surnameTmp;
	}

	
	
	//toString
	
	@Override
	public String toString() {
		return "Name: " + name + ", Surname: " + surname;
	}
	
	
	
}
