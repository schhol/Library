package com.demo.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.BookRepo;
import com.example.demo.model.EmployeeRepo;
import com.example.demo.model.LibraryDepartmentRepo;
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
	
		//Users for readers
		User u1 = new User("Janis", "111");
		User u2 = new User("Liga", "222");
		User u3 = new User("Juris", "333");
				
		//Users for employees
		User u4 = new User("Anna", "444");
		User u5 = new User("Ivo", "555");
		User u6 = new User("Baiba", "666");
				
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);
		userRepo.save(u6);
		
		
		
		
		
		return "ok";
	}
	
}
