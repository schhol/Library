package com.example.demo.model;

import java.util.Calendar;

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
	
	@Column(name = "Department")
	private String department;
	
	@OneToOne
	@JoinColumn(name = "Id_u")
	private User userEmp;

	
	//Constructors
	
	public Employee(@NotNull @Size(min = 3, max = 15) String name, @NotNull @Size(min = 3, max = 15) String surname,
			String department) {
		super();
		this.name = name;
		this.surname = surname;
		this.department = department;
	}
	
	public Employee() {
		super();
	}

		//Get && Set
		public int getId_e() {
		return id_e;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
