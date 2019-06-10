package com.example.demo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DepartmentTable")
public class LibraryDepartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_dp")
	int id_dp;
	
	@OneToMany(mappedBy = "department")
	private Collection<Book> booklist;
	
	@NotNull
	@Size(min = 3, max = 10)
	@Column(name = "Specialization")
	private String specialization;
	
	@Column(name = "EmployeesInDepartment")
	private ArrayList <Employee> allEmployees;



	
	//chemestry, mathematics, physics, business, IT, languages, poetry
	//Constructors
	public LibraryDepartment(Collection<Book> booklist, @NotNull @Size(min = 3, max = 10) String specialization,
			ArrayList<Employee> allEmployees) {
		super();
		this.booklist = booklist;
		this.specialization = specialization;
		this.allEmployees = allEmployees;
	}

	public LibraryDepartment() {
		super();
	}

	
	//Get & Set
	public Collection<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(Collection<Book> booklist) {
		this.booklist = booklist;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ArrayList<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(ArrayList<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public int getId_dp() {
		return id_dp;
	}
	
	
	
	
}
