package com.example.demo.model;

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
public class LibraryDepartment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_dp")
	int id_dp;
	
	@OneToMany(mappedBy = "department")
	private Collection<Book> booklist;
	
	@NotNull
	@Size(min = 3, max = 10)
	@Column(name = "Title")
	private String title;		//chemestry, mathematics, physics, business, IT, languages, poetry
	
	@OneToMany(mappedBy = "department")
	private Collection<Employee> allEmployees;



	
	//Constructors
	
	public LibraryDepartment() {
	}
	
	public LibraryDepartment(@NotNull @Size(min = 3, max = 10) String title) {
		setTitle(title);
	}

	

	
	//Get & Set

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
			this.title = "Science";
		}
	}

	public int getId_dp() {
		return id_dp;
	}

	public Collection<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(Collection<Book> booklist) {
		this.booklist = booklist;
	}

	public Collection<Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(Collection<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}
	
	
	
	
	
	
}
