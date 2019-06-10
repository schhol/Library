package com.example.demo.model;

import java.util.Arrays;

public class Person {
	
	//Mainigie
	
	private String name;
	private String surname;
	
	private int[] identificator = {0,1,0,1,0,1,1,1,1,1,1};
	

	
	
	//Konstruktori
	
	public Person() {
		name = "Janis";
		surname = "Berzins";
		setIdentificator(identificator);
	}
	
	public Person(String name, String surname, int[] identificator) {
		setName(name);
		setSurname(surname);
		setIdentificator(identificator);
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

	
	
	
	public int[] getIdentificator() {
		return identificator;
	}

	/**
	 * @param identificator - Personas ID kods
	 * 
	 * Dienai, menesim un gadam parbauda vai tie atbilst patiesam vertibam
	 * 
	 * For ciklaa parbauda ID koda pedejos 6 ciparus (tiem jabut robezas no 0 lidz 9)
	 * 
	 * Pec visam parbaudem un, ja nepieciesams, izmainam, objekta mainigajam identicifator pieskir padoto parametru identificator
	 * 
	 */
	public void setIdentificator(int[] identificator) {
		
		int diena = identificator[0] * 10 + identificator[1];
		int menesis = identificator[2] * 10 + identificator[3];
		int gads = identificator[4] * 10 + identificator[5];
		
		if(diena < 1 || diena > 31){
			identificator[0] = 0;
			identificator[1] = 1;
		}
		
		if(menesis < 1 || menesis > 12){
			identificator[2] = 0;
			identificator[3] = 1;
		}
		
		if(gads < 0 || gads > 99){
			identificator[4] = 0;
			identificator[5] = 0;
		}
		
		for (int i = 6; i <= identificator[10]; i++) {
			if(identificator[i] <= 0 || identificator[i] > 9){
				identificator[i] = 1;
			}
		}
		
		this.identificator = identificator;
	}


	
	//toString
	
	@Override
	public String toString() {
		return "Name: " + name + ", Surname: " + surname + ", Identificator: " + Arrays.toString(identificator);
	}
	
	
	
}
