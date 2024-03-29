package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.model.Employee;
import com.example.demo.model.LibraryDepartment;
import com.example.demo.model.Reader;
import com.example.demo.model.User;
import com.example.demo.repos.BookRepo;
import com.example.demo.repos.EmployeeRepo;
import com.example.demo.repos.LibraryDepartmentRepo;
import com.example.demo.repos.ReaderRepo;
import com.example.demo.repos.UserRepo;

@SpringBootApplication
public class LibrarySystemJavaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LibrarySystemJavaApplication.class, args);
	}
	
	//ievieto dummy data datu bazes aplikacijas palaisanas bridi
	@Component
	public class DemoData implements ApplicationRunner {

		@Autowired
		UserRepo userRepo;
		
		@Autowired
		ReaderRepo readerRepo;
		
		@Autowired
		BookRepo bookRepo;
		
		@Autowired
		EmployeeRepo employeeRepo;
		
		@Autowired
		LibraryDepartmentRepo libraryDepartmentRepo;
		
		
		@Override
		public void run(ApplicationArguments args) throws Exception {
			
			User u1 = new User("Janis", "111");
			User u2 = new User("Employee1", "admin1");
			User u3 = new User("Employee2", "admin2");
								
			userRepo.save(u1);
			userRepo.save(u2);
			userRepo.save(u3);
					
			LibraryDepartment ld1 = new LibraryDepartment("Science");
			LibraryDepartment ld2 = new LibraryDepartment("Sport");
			LibraryDepartment ld3 = new LibraryDepartment("Art");
			
			libraryDepartmentRepo.save(ld1);
			libraryDepartmentRepo.save(ld2);
			libraryDepartmentRepo.save(ld3);
					
			Employee emp1 = new Employee("Anna", "Berzina", ld1, u2);
			Employee emp2 = new Employee("Ivo", "Berzins", ld1, u3);
			employeeRepo.save(emp1);
			employeeRepo.save(emp2);
					
			
			Book b1 = new Book("4739602758", 2010 ,"Mathematics", "John Stuart", 4.9, "Good", 3, "This book is the foundation for basic mathematics and geometry.", ld1);
			Book b2 = new Book("9438657301", 2010 ,"Biology", "Ann Lee", 4.5, "VeryGood", 4, "From single cell organisms to complicated sophisticated life forms.", ld1);
			Book b3 = new Book("6386930284", 2011 ,"Football", "Rob Stone", 4.5, "Bad", 4, "In this book I have collected the best training methods to become great at football.", ld2);
			Book b4 = new Book("9483958429", 2011 ,"Hockey", "Derick Johnson", 4.5, "Fine", 4, "History of hockey is amazing. Dive into the past to know why hockey is like it is now.", ld2);
			Book b5 = new Book("9836485069", 2020 ,"Colors", "Bob Adams", 4.5, "Good", 4, "Explore the wonderful world full of colours and its meanings.", ld3);
			Book b6 = new Book("2583952395", 2016 ,"Lighting", "Michael Allinson", 4.5, "VeryGood", 4, "Light is one of the most essential elements in art.", ld3);
			
			b1.setTimesTaken(150);
			b2.setTimesTaken(50);
			b3.setTimesTaken(1);
			b4.setTimesTaken(45);
			b5.setTimesTaken(48);
			b6.setTimesTaken(12);

			bookRepo.save(b1);
			bookRepo.save(b2);
			bookRepo.save(b3);
			bookRepo.save(b4);
			bookRepo.save(b5);
			bookRepo.save(b6);
			

			Reader r1 = new  Reader("Janis", "Kalnins", u1);
			readerRepo.save(r1);
			
		}
	}

}
