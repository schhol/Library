package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	

	//TODO sasaiste starp book un reader

	
	//------------------------------------------------------------------------------------------------------
	//---------------------------------------------GUEST----------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	//Home screen
	@GetMapping(value = "/homeGuest")
	public String homeGuest(Model model) {
		ArrayList<Book> allBooksFromDB = (ArrayList<Book>) bookRepo.findByOrderByTimesTakenDesc();
		ArrayList<Book> top5Books = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			top5Books.add(allBooksFromDB.get(i));
		}
		
		model.addAttribute("allbooks", top5Books);
		return "homeguest";
	}
	
	
	
	String keywordGuest;
	@PostMapping(value = "/homeGuest")
	public String SearchBookGuest(String keyname) {
		
		keywordGuest = keyname; 
		System.out.println("-------------------------------" + keyname);
		return "redirect:/foundTableGuest";
	}
	
	
	
	@GetMapping(value = "/foundTableGuest")
	public String booksFoundGuest(Model model) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		System.out.println(keywordGuest);
		
		int count = 0;
		int year = 0;
		for (int i = 0; i < keywordGuest.length(); i++) {
			if(Character.isDigit(keywordGuest.charAt(i))) {
				count++;
			}
		}
		if(count == keywordGuest.length()) {
			 year = Integer.parseInt(keywordGuest);
		}
		
		foundBooks.addAll(bookRepo.findByAuthor(keywordGuest));
		
		foundBooks.addAll(bookRepo.findByTitle(keywordGuest));
		
		foundBooks.addAll(bookRepo.findByYear(year));
		
		model.addAttribute("keyword", keywordGuest);
		model.addAttribute("booksfound", foundBooks);
		
		return "foundbooksguest";
	}
	
	
	//For searching in search log
	@PostMapping(value = "/foundTableGuest")
	public String searchSearchBookGuest(String keyname) {
		
		keywordGuest = keyname; 
		System.out.println("-------------------------------" + keyname);
		return "redirect:/foundTableGuest";
	}
	
	
	
	@GetMapping(value = "/guestBook/{id}")
	public String guestBookView(Model model, @PathVariable(name = "id") int id) {
		Book bookTemp = bookRepo.findById(id);
		model.addAttribute("Book", bookTemp);
		
		return "bookviewguest";
	}
	
	
	//------------------------------------------------------------------------------------------------------
	//--------------------------------------------READER----------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	@GetMapping(value = "/homeReader/{id}")
	public String homeReader(Model model, @PathVariable(name = "id") int id) {
		ArrayList<Book> allBooksFromDB = (ArrayList<Book>) bookRepo.findByOrderByTimesTakenDesc();
		ArrayList<Book> top5Books = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			top5Books.add(allBooksFromDB.get(i));
		}
		
		User userTemp = userRepo.findById(id);
		model.addAttribute("User", userTemp);
		
		model.addAttribute("allbooks", top5Books);
		return "homereader";
	}
	
	
	
	
	String keywordReader;
	@PostMapping(value = "/homeReader/{id}")
	public String SearchBookReader(String keyname) {
		
		keywordReader = keyname; 
		System.out.println("-------------------------------" + keyname);
		return "redirect:/foundTableReader";
	}
	
	
	
	
	@GetMapping(value = "/foundTableReader")
	public String booksFoundReader(Model model) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		System.out.println(keywordReader);
		
		int count = 0;
		int year = 0;
		for (int i = 0; i < keywordReader.length(); i++) {
			if(Character.isDigit(keywordReader.charAt(i))) {
				count++;
			}
		}
		if(count == keywordReader.length()) {
			 year = Integer.parseInt(keywordReader);
		}

		foundBooks.addAll(bookRepo.findByAuthor(keywordReader));
		
		foundBooks.addAll(bookRepo.findByTitle(keywordReader));
		
		foundBooks.addAll(bookRepo.findByYear(year));
		
		model.addAttribute("keyword", keywordReader);
		model.addAttribute("booksfound", foundBooks);
		
		return "foundbooksreader";
	}

	
	//Var dzest komentaru
	@PostMapping(value = "/foundTableReader")
	public String searchSearchBookReader(String keyname) {
		
		keywordReader = keyname; 
		System.out.println("-------------------------------" + keyname);
		return "redirect:/foundTableReader";
	}
	
	
	
	@GetMapping(value = "/profile/{id}")
	public String readerProfile(Model model, @PathVariable(name = "id") int id) {
		User userTemp = userRepo.findById(id);
		Reader readerTemp = readerRepo.findByUserRead(userTemp);
		
		model.addAttribute("User", userTemp);
		for(Book b : readerTemp.getCurrentTakenBookList()) {
			System.out.println(b.getTitle());
		}
		
		model.addAttribute("allbooks", readerTemp.getCurrentTakenBookList());
		return "readerprofile";
	}
	
	
	//------------------------------------------------------------------------------------------------------
	//--------------------------------------------EMPLOYEE--------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	@GetMapping(value = "/homeEmployee/{id}")
	public String homeEmployee(Model model, @PathVariable(name = "id") int id) {
		ArrayList<Book> allBooksFromDB = (ArrayList<Book>) bookRepo.findByOrderByTimesTakenDesc();
		
		
		model.addAttribute("allbooks", allBooksFromDB);
		return "homeemployee";
	}
	
	
	
	String keywordEmployee;
	@PostMapping(value = "/homeEmployee/{id}")
	public String SearchBookEmployee(String keyname, @PathVariable(name = "id") int id) {
		
		keywordEmployee = keyname; 
		System.out.println("-------------------------------" + keyname);
		return "redirect:/foundTableEmployee";
	}
	
	
	
	@GetMapping(value = "/foundTableEmployee")
	public String booksFoundEmployee(Model model) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		System.out.println(keywordEmployee);
		
		int count = 0;
		int year = 0;
		for (int i = 0; i < keywordEmployee.length(); i++) {
			if(Character.isDigit(keywordEmployee.charAt(i))) {
				count++;
			}
		}
		if(count == keywordEmployee.length()) {
			 year = Integer.parseInt(keywordEmployee);
		}

		foundBooks.addAll(bookRepo.findByAuthor(keywordEmployee));
		
		foundBooks.addAll(bookRepo.findByTitle(keywordEmployee));
		
		foundBooks.addAll(bookRepo.findByYear(year));
		
		model.addAttribute("keyword", keywordEmployee);
		model.addAttribute("booksfound", foundBooks);
		
		return "foundbooksemployee";
	}

	
	//Var dzest komentaru
	@PostMapping(value = "/foundTableEmployee")
	public String searchSearchBookEmployee(String keyname) {
		
		keywordEmployee = keyname; 
		System.out.println("-------------------------------" + keyname);
		return "redirect:/foundTableEmployee";
	}
	
	
	
	//jaunas gramatas pievienosanas skats
	@GetMapping(value = "/addBook")
	public String addBook(Book book){
		return "addbook";
	}
			
	@PostMapping(value = "/addBook")
	public String addBookPost(Book book){
			
		Book bookTemp = bookRepo.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
				
		if(bookTemp == null){
			Book newBook = book;
			bookRepo.save(newBook);
			return "redirect:/homeEmployee";
		}
			
		else if(bookTemp.getCoppies() >= 1 && bookTemp.getCoppies() < 5) {
			bookTemp.addCopy();
			bookRepo.save(bookTemp);
			return "redirect:/homeEmployee";
		}
			
		else{
			return "addbookfail";
		}
	}
	
	
	//------------------------------------------------------------------------------------------------------
	//--------------------------------------------OTHERS--------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	//autorizacijas skats
	@GetMapping(value = "/authorise")
	public String authorise(User user){
		return "authorise";
	}
	
	
	int id = -1;
	//post-autorizacija, iegust lietotaja ievadito info
	@PostMapping(value = "/authorise")
	public String authorisePost(User user){
		User userTemp = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(userTemp != null) {
			id = userTemp.getId_u();

			if(userTemp.getReader() != null && userTemp.getEmployee() == null) {
				return "redirect:/homeReader/" + id;
			}
			else {
				return "redirect:/homeEmployee/" + id;
			}
		}
		
		else {
			return "authorisefail";
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
	
	//forsais
	
}