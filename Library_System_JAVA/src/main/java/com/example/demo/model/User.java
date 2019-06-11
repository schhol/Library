package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UserTable")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "Id_u")
		private int id_u;
		
		@NotNull
		@Size (min = 3, max = 10)
		@Column(name = "Username")
		private String username;
		
		@NotNull
		@Size (min = 3, max = 10)
		@Column(name = "Password")
		private String password;

		@OneToOne(mappedBy = "userEmp")
		private Employee employee;
		
		@OneToOne(mappedBy = "userRead")
		private Reader reader;
		
		//Constructors
		public User() {
			super();
		}

		public User( @NotNull @Size(min = 3, max = 10) String username,
				@NotNull @Size(min = 3, max = 10) String password) {
			super();
			this.username = username;
			this.password = password;
		
		}

		//Get && Set
		public int getId_u() {
			return id_u;
		}


		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;		
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public Reader getReader() {
			return reader;
		}

		public void setReader(Reader reader) {
			this.reader = reader;
		}
		
		
}
