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

					
					
			Book b1 = new Book("1111111111", 2010 ,"book", "Dude", 4.9, "Good", 3, "Good book about dudes", ld1);
			Book b2 = new Book("1112211111", 2010 ,"gramata", "Picasso", 4.5, "VeryGood", 4, "Good book about art", ld1);
			Book b3 = new Book("1112211111", 2011 ,"sdfs", "Picddasso", 4.5, "VeryGood", 4, "Good book about art", ld1);
			Book b4 = new Book("1112211111", 2011 ,"sdaa", "Picaswsqssso", 4.5, "VeryGood", 4, "Good book about art", ld1);
			Book b5 = new Book("1112211111", 2020 ,"asas", "Picaaasso", 4.5, "VeryGood", 4, "Good book about art", ld1);
			Book b6 = new Book("1112211111", 2016 ,"gsdsdsd", "Pissscasso", 4.5, "VeryGood", 4, "Good book about art", ld1);
			
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
			


			
		}
	}

}
