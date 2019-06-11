package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Book;
import com.example.demo.model.BookRepo;
import com.example.demo.model.EmployeeRepo;
import com.example.demo.model.LibraryDepartmentRepo;
import com.example.demo.model.Reader;
import com.example.demo.model.ReaderRepo;
import com.example.demo.model.User;
import com.example.demo.model.UserRepo;

@Controller
public class LibraryController {

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
	
	
	
	@GetMapping(value = "/testingData")
	public String testingData(){
	
		int[] ibn = {1,1,1,1,1,1,1,1,1,1};
		Date date = new Date(2010);
		//Users for readers
		User u1 = new User("Janis", "111");
		User u2 = new User("Liga", "222");
		User u3 = new User("Juris", "333");
				
		//Users for employees
		User u4 = new User("Anna", "444");
		User u5 = new User("Ivo", "555");
		User u6 = new User("Baiba", "666");
		
		Book b1 = new Book(ibn, date,"book", "Dude", 10, "GOOD", "Common", "Good book about dudes");
		
				
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);
		userRepo.save(u6);
		
		System.out.println("User count: " + userRepo.count());
		
		return "ok";
	}
	
	
	//autorizacijas skats
	@GetMapping(value = "/authorise")
	public String authorise(User user){
		return "authorise";
	}
		
	//post-autorizacija, iegust lietotaja ievadito info
	@PostMapping(value = "/authorise")
	public String authorisePost(User user){
		boolean inSystem = false;
		int id = -1;
		User userTemp = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(userTemp != null) {
			inSystem = true;
			id = userTemp.getId_u();
			System.out.println(id);
			return "ok";
		}
		
		else {
			return "redirect:/error";
		}
		
	}
	
	//registracijas skats
	@GetMapping(value = "/registration")
	public String registration(User user){
		return "registration";
	}
	
	@PostMapping(value = "/registration")
	public String registrationPost(User user){
		String name = user.getReader().getName();
		String surname = user.getReader().getSurname();
		String username = user.getUsername();
		String password = user.getPassword();
		
		Reader newReader = new Reader(name, surname);
		User newUser = new User(username, password);
		
		User userTemp = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(userTemp == null) {
			
			newUser.setReader(newReader);
			userRepo.save(newUser);
			
			newReader.setUserRead(newUser);
			readerRepo.save(newReader);
			return "redirect:/authorise";
		}
		
		else{
			return  "registerfail";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
