package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.model.Book;
import com.example.demo.model.BookRepo;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepo;
import com.example.demo.model.LibraryDepartment;
import com.example.demo.model.LibraryDepartmentRepo;
import com.example.demo.model.Reader;
import com.example.demo.model.ReaderRepo;
import com.example.demo.model.User;
import com.example.demo.model.UserRepo;

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
			User u2 = new User("Liga", "222");
			User u3 = new User("Juris", "333");
								
			userRepo.save(u1);
			userRepo.save(u2);
			userRepo.save(u3);
					
			LibraryDepartment ld1 = new LibraryDepartment("Jokes");
			libraryDepartmentRepo.save(ld1);
					
			Employee emp1 = new Employee("Anna", "Berzina", ld1, u2);
			Employee emp2 = new Employee("Ivo", "Berzins", ld1, u3);
			employeeRepo.save(emp1);
			employeeRepo.save(emp2);
					
			Reader r1 = new  Reader("Janis", "Kalnins", u1);
			readerRepo.save(r1);
					
					
			Book b1 = new Book("1111111111", 2010 ,"book", "Dude", 4.9, "GOOD", "Common", "Good book about dudes", ld1);
			Book b2 = new Book("1112211111", 2010 ,"gramata", "Picasso", 4.5, "GOOD", "Common", "Good book about art", ld1);

			bookRepo.save(b1);
			bookRepo.save(b2);
			
		}
	}

}
