package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	//Home screen
	//kim
	@GetMapping(value = "/Home")
	public String Homescreen() {
		return "homescreen";
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
		
		User userTemp = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(userTemp == null) {
			
			User newUser = new User(username, password);
			userRepo.save(newUser);
			Reader newReader = new Reader(name, surname, newUser);
			readerRepo.save(newReader);
			newUser.setReader(newReader);
			userRepo.save(newUser);
			
			return "redirect:/authorise";
		}
		
		
		else{
			return  "registerfail";
		}

	}

	//vai darbojas? pt. 2
	
	
	
	
	
	
	
	
	
	
	
}