package com.example.demo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
}
