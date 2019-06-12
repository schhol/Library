package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EmployeeTable")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_e")
	int id_e;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "Name")
	private String name;
	
	@NotNull
	@Size(min = 3, max = 15)
	@Column(name = "Surame")
	private String surname;
	
	@OneToOne
	@JoinColumn(name = "Id_u")
	private User userEmp;
	
	@ManyToOne
	@JoinColumn(name = "Id_dp")
	private LibraryDepartment department;

	
	//Constructors
	
	public Employee() {
	}
	
	public Employee(@NotNull @Size(min = 3, max = 15) String name, @NotNull @Size(min = 3, max = 15) String surname, LibraryDepartment department, User userEmp) {
		super();
		setName(name);
		setSurname(surname);
		setDepartment(department);
		setUserEmp(userEmp);
	}
	

	//Get && Set
	
	public int getId_e() {
		return id_e;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		String nameTmp = "";
		if(name.length() != 0) {
			for (int i = 0; i < name.length(); i++) {
				if(Character.isLetter(name.charAt(i))){
					nameTmp += name.charAt(i);
				}
			}
			this.name = nameTmp;
		}
		else {
			this.name = "Ivo";
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		String surnameTmp = "";
		if(surname.length() != 0) {
			for (int i = 0; i < surname.length(); i++) {
				if(Character.isLetter(surname.charAt(i))){
					surnameTmp += surname.charAt(i);
				}
			}
			this.surname = surnameTmp;
		}
		else {
			this.surname = "Kalnins";
		}
	}

	public LibraryDepartment getDepartment() {
		return department;
	}

	public void setDepartment(LibraryDepartment department) {
		this.department = department;
	}

	public User getUserEmp() {
		return userEmp;
	}

	public void setUserEmp(User userEmp) {
		this.userEmp = userEmp;
	}
	
	
	
	
}
