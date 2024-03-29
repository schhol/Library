package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Book;
import com.example.demo.model.LibraryDepartment;
import com.example.demo.model.Reader;
import com.example.demo.model.User;
import com.example.demo.repos.BookRepo;
import com.example.demo.repos.EmployeeRepo;
import com.example.demo.repos.LibraryDepartmentRepo;
import com.example.demo.repos.ReaderRepo;
import com.example.demo.repos.UserRepo;

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
	

	//TODO pabeigt department meklesanas
	//koment

	
	//------------------------------------------------------------------------------------------------------
	//---------------------------------------------GUEST----------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	//Home screen
	@GetMapping(value = "/homeGuest")
	public String homeGuest(Model model) {
		ArrayList<Book> allBooksFromDB = (ArrayList<Book>) bookRepo.findByOrderByTimesTakenDesc();
		ArrayList<Book> top5Books = new ArrayList<>();
		if(allBooksFromDB != null) {
			for (int i = 0; i < 5; i++) {
				top5Books.add(allBooksFromDB.get(i));
			}
			
			model.addAttribute("allbooks", top5Books);
			return "homeguest";
		}
		else {
			return "error";
		}
		
	}
	
	
	
	String keywordGuest;
	@PostMapping(value = "/homeGuest")
	public String SearchBookGuest(String keyname) {
		
		keywordGuest = keyname; 

		return "redirect:/foundTableGuest";
	}
	
	
	
	@GetMapping(value = "/foundTableGuest")
	public String booksFoundGuest(Model model) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		
		int count = 0;
		int year = 0;
		for (int i = 0; i < keywordGuest.length(); i++) {
			if(Character.isDigit(keywordGuest.charAt(i))) {
				count++;
			}
		}
		if(count == keywordGuest.length() && count >=1 && count <=4) {
			 year = Integer.parseInt(keywordGuest);
		}
		
		foundBooks.addAll(bookRepo.findByAuthor(keywordGuest));
		
		foundBooks.addAll(bookRepo.findByTitle(keywordGuest));
		
		foundBooks.addAll(bookRepo.findByYear(year));
	
		model.addAttribute("keywordGuest", keywordGuest);
		model.addAttribute("booksfound", foundBooks);
		
		if(foundBooks.isEmpty() || keywordGuest == ""){
			return "guestsearchfail";
		}
		else {
			return "foundbooksguest";
		}
		
	}
	
	
	//For searching in search log
	@PostMapping(value = "/foundTableGuest")
	public String searchSearchBookGuest(String keyname) {
		
		keywordGuest = keyname; 
		
		return "redirect:/foundTableGuest";
	}
	
	
	
	@GetMapping(value = "/guestBook/{id}")
	public String guestBookView(Model model, @PathVariable(name = "id") int id) {
		Book bookTemp = bookRepo.findById(id);
		
		if(bookTemp != null) {
			model.addAttribute("Book", bookTemp);
			
			return "bookviewguest";
		}
		else {
			return "error";
		}
		
	}
	
	
	@GetMapping(value = "/departmentScienceGuest")
	public String departmentScienceGuest(Model model){
		LibraryDepartment departmentTemp = libraryDepartmentRepo.findByTitle("Science");
		ArrayList<Book> scienceBooks = bookRepo.findByDepartment(departmentTemp);
		
		if(departmentTemp != null && scienceBooks != null) {
			model.addAttribute("ScienceBooks", scienceBooks);
		
			return "departmentscienceguest";
		}
		else {
			return "error";
		}
	}
	
	
	
	@GetMapping(value = "/departmentSportGuest")
	public String departmentSportGuest(Model model){
		LibraryDepartment departmentTemp = libraryDepartmentRepo.findByTitle("Sport");
		ArrayList<Book> sportBooks = bookRepo.findByDepartment(departmentTemp);
		
		if(departmentTemp != null && sportBooks != null) {
			model.addAttribute("SportBooks", sportBooks);
			
			return "departmentsportguest";
		}
		else {
			return "error";
		}
	}
	
	
	@GetMapping(value = "/departmentArtGuest")
	public String departmentArtGuest(Model model){
		LibraryDepartment departmentTemp = libraryDepartmentRepo.findByTitle("Art");
		ArrayList<Book> artBooks = bookRepo.findByDepartment(departmentTemp);
		
		if(departmentTemp != null && artBooks != null) {
			model.addAttribute("ArtBooks", artBooks);
			
			return "departmentartguest";
		}
		else {
			return "error";
		}
	}
	
	
	
	//------------------------------------------------------------------------------------------------------
	//--------------------------------------------READER----------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	
	@GetMapping(value = "/homeReader/{id}")
	public String homeReader(Model model, @PathVariable(name = "id") int id) {
		ArrayList<Book> allBooksFromDB = (ArrayList<Book>) bookRepo.findByOrderByTimesTakenDesc();
		ArrayList<Book> top5Books = new ArrayList<>();
		User userTemp = userRepo.findById(id);
		
		if(userTemp != null && allBooksFromDB != null) {
		
		for (int i = 0; i < 5; i++) {
			top5Books.add(allBooksFromDB.get(i));
		}
		
		
		
		
			model.addAttribute("User", userTemp);
			
			model.addAttribute("allbooks", top5Books);
			return "homereader";
		}
		else {
			return "error";
		}
		
	}
	
	
	
	
	String keywordReader;
	@PostMapping(value = "/homeReader/{id}")
	public String SearchBookReader(String keyname, @PathVariable(name = "id") int id) {
		
		keywordReader = keyname; 

		return "redirect:/foundTableReader/"+id;
	}
	
	
	
	
	@GetMapping(value = "/foundTableReader/{id}")
	public String booksFoundReader(Model model, @PathVariable(name = "id") int id) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		
		int count = 0;
		int year = 0;
		for (int i = 0; i < keywordReader.length(); i++) {
			if(Character.isDigit(keywordReader.charAt(i))) {
				count++;
			}
		}
		if(count == keywordReader.length() && count >=1 && count <= 4) {
			 year = Integer.parseInt(keywordReader);
		}

		foundBooks.addAll(bookRepo.findByAuthor(keywordReader));
		
		foundBooks.addAll(bookRepo.findByTitle(keywordReader));
		
		foundBooks.addAll(bookRepo.findByYear(year));
		
		User userTemp = userRepo.findById(id);
		
		if(userTemp != null) {
			model.addAttribute("User", userTemp);
			
			model.addAttribute("keywordReader", keywordReader);
			model.addAttribute("booksfound", foundBooks);
			
			if(foundBooks.isEmpty() || keywordReader == "") {
				return "readersearchfail";
			}
			else {
				return "foundbooksreader";
			}
		}
		else {
			return "error";
		}
		
		
		
	}

	
	
	@PostMapping(value = "/foundTableReader/{id}")
	public String searchSearchBookReader(String keyname, @PathVariable(name = "id") int id) {
		
		keywordReader = keyname; 

		return "redirect:/foundTableReader/"+id;
	}
	
	
	
	@GetMapping(value = "/profile/{id}")
	public String readerProfile(Model model, @PathVariable(name = "id") int id) {
		User userTemp = userRepo.findById(id);
		Reader readerTemp = readerRepo.findByUserRead(userTemp);
		
		if(userTemp != null && readerTemp != null) {
			if(readerTemp.getCurrentTakenBookList().isEmpty()) {
				model.addAttribute("User", userTemp);
				return "readerprofileempty";
			}
			else {
				model.addAttribute("User", userTemp);
				model.addAttribute("allbooks", readerTemp.getCurrentTakenBookList());
				return "readerprofile";
			}
			
		}
		
		else {
			return "error";
		}
		
		
	}
	
	@PostMapping(value = "/profile/{id}")
	public String profilePost(Model model, String keyname, @PathVariable(name = "id") int id) {
		
		keywordReader = keyname; 

		return "redirect:/foundTableReader/"+id;
	}
	

	@GetMapping(value = "/readerBook/{id_u}/{id_b}")
	public String readerBookView(Model model, @PathVariable(name = "id_u") int id_u, @PathVariable(name = "id_b") int id_b) {
		Book bookTemp = bookRepo.findById(id_b);
		User userTemp = userRepo.findById(id_u);

		if(bookTemp != null && userTemp != null) {
			model.addAttribute("User", userTemp);
			model.addAttribute("Book", bookTemp);
			
			return "bookviewreader";
		}
		else {
			return "error";
		}
		
	}
	
	@PostMapping(value = "readerBook/{id_u}/{id_b}")
	public String bookSavingToReader(@PathVariable(name = "id_u") int id_u, @PathVariable(name = "id_b") int id_b) {
		boolean isInReader = false;
		Book bookTemp = bookRepo.findById(id_b);
		User userTemp = userRepo.findById(id_u);
		Reader readerTemp = readerRepo.findByUserRead(userTemp);
		
		if(bookTemp != null && userTemp != null && readerTemp != null) {
		
			for (Book b : readerTemp.getCurrentTakenBookList()) {
				if(b.equals(bookTemp)) {
					isInReader = true;
					break;
				}
			}
			
			if(isInReader == true) {
				return "redirect:/readerBookReturn/"+ id_u +"/"+ id_b;
			}
			else if(isInReader == false && bookTemp.isAvailable()) {
				bookTemp.takeBook();
				readerTemp.takeABook(bookTemp);
				readerRepo.save(readerTemp);
				
				return "redirect:/readerBookReturn/"+ id_u +"/"+ id_b;
			}
			else {
				return "bookNotAvailable";
			}
		}
		else {
			return "error";
		}
		
		
	}
	
	@GetMapping(value = "readerBookReturn/{id_u}/{id_b}")
	public String readerReturnBookView(Model model,@PathVariable(name = "id_u") int id_u, @PathVariable(name = "id_b") int id_b) {
		
		Book bookTemp = bookRepo.findById(id_b);
		User userTemp = userRepo.findById(id_u);
		
		if(bookTemp != null && userTemp != null) {
			model.addAttribute("User", userTemp);
			model.addAttribute("Book", bookTemp);
			
			return"bookviewreaderreturn";
		}
		else {
			return "error";
		}
		
	}
	
	
	@PostMapping(value = "readerBookReturn/{id_u}/{id_b}")
	public String returningBook(@PathVariable(name = "id_u") int id_u, @PathVariable(name = "id_b") int id_b) {
		boolean isInReader = false;
		Book bookTemp = bookRepo.findById(id_b);
		User userTemp = userRepo.findById(id_u);
		Reader readerTemp = readerRepo.findByUserRead(userTemp);
		
		if(bookTemp != null && userTemp != null && readerTemp != null) {
			for (Book b : readerTemp.getCurrentTakenBookList()) {
				if(b.equals(bookTemp)) {
					isInReader = true;
					break;
				}
			}
			
			if(isInReader == true) {
				readerTemp.getCurrentTakenBookList().remove(bookTemp);
				readerRepo.save(readerTemp);
				return "redirect:/readerBook/"+ id_u +"/"+ id_b;
			}
			else{	
				return "redirect:/readerBook/"+ id_u +"/"+ id_b;
			}
		}
		else {
			return "error";
		}
		
	}
	
	
	
	@GetMapping(value = "/departmentScienceReader/{id}")
	public String departmentScienceReader(Model model, @PathVariable(name = "id") int id){
		User userTemp = userRepo.findById(id);
		
		LibraryDepartment departmentTemp = libraryDepartmentRepo.findByTitle("Science");
		ArrayList<Book> scienceBooks = bookRepo.findByDepartment(departmentTemp);
		
		model.addAttribute("User", userTemp);
		model.addAttribute("ScienceBooks", scienceBooks);
		
		return "departmentsciencereader";
	}
	
	
	
	@GetMapping(value = "/departmentSportReader/{id}")
	public String departmentSportReader(Model model,@PathVariable(name = "id") int id){
		User userTemp = userRepo.findById(id);
		
		LibraryDepartment departmentTemp = libraryDepartmentRepo.findByTitle("Sport");
		ArrayList<Book> sportBooks = bookRepo.findByDepartment(departmentTemp);
		
		model.addAttribute("User", userTemp);
		model.addAttribute("SportBooks", sportBooks);
		
		return "departmentsportsreader";
	}
	
	
	@GetMapping(value = "/departmentArtReader/{id}")
	public String departmentArtReader(Model model, @PathVariable(name = "id") int id){
		User userTemp = userRepo.findById(id);
		
		LibraryDepartment departmentTemp = libraryDepartmentRepo.findByTitle("Art");
		ArrayList<Book> artBooks = bookRepo.findByDepartment(departmentTemp);
		
		model.addAttribute("User", userTemp);
		model.addAttribute("ArtBooks", artBooks);
		
		return "departmentartreader";
	}
	
	
	//------------------------------------------------------------------------------------------------------
	//--------------------------------------------EMPLOYEE--------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	
	
	@GetMapping(value = "/homeEmployee/{id}")
	public String homeEmployee(Model model, @PathVariable(name = "id") int id) {
		ArrayList<Book> allBooksFromDB = (ArrayList<Book>) bookRepo.findByOrderByTimesTakenDesc();
		
		User userTemp = userRepo.findById(id);
		
		if(userTemp != null && allBooksFromDB != null) {
			model.addAttribute("User", userTemp);
			
			model.addAttribute("allbooks", allBooksFromDB);
			return "homeemployee";
		}
		else {
			return "error";
		}
		
	}
	
	
	
	String keywordEmployee;
	@PostMapping(value = "/homeEmployee/{id}")
	public String SearchBookEmployee(String keyname, @PathVariable(name = "id") int id) {
		
		keywordEmployee = keyname; 

		return "redirect:/foundTableEmployee/" + id;
	}
	
	
	
	@GetMapping(value = "/foundTableEmployee/{id}")
	public String booksFoundEmployee(Model model, @PathVariable(name = "id") int id) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		
		int count = 0;
		int year = 0;
		for (int i = 0; i < keywordEmployee.length(); i++) {
			if(Character.isDigit(keywordEmployee.charAt(i))) {
				count++;
			}
		}
		if(count == keywordEmployee.length() && count >=1 && count <= 4) {
			 year = Integer.parseInt(keywordEmployee);
		}

		foundBooks.addAll(bookRepo.findByAuthor(keywordEmployee));
		
		foundBooks.addAll(bookRepo.findByTitle(keywordEmployee));
		
		foundBooks.addAll(bookRepo.findByYear(year));
		
		User userTemp = userRepo.findById(id);
		
		if(userTemp != null) {
			model.addAttribute("User", userTemp);
			
			model.addAttribute("keywordEmployee", keywordEmployee);
			model.addAttribute("booksfound", foundBooks);
			
			if(foundBooks.isEmpty() || keywordEmployee == "") {
				return "employeesearchfail";
			}
			else {
				return "foundbooksemployee";
			}
		}
		else {
			return "error";
		}
	}

	
	//Var dzest komentaru
	@PostMapping(value = "/foundTableEmployee/{id}")
	public String searchSearchBookEmployee(String keyname, @PathVariable(name = "id") int id) {
		
		keywordEmployee = keyname; 

		return "redirect:/foundTableEmployee" + id;
	}
	
	
	
	@GetMapping(value = "/employeeBook/{id_u}/{id_b}")
	public String employeeBookView(Model model, @PathVariable(name = "id_u") int id_u, @PathVariable(name = "id_b") int id_b) {
		Book bookTemp = bookRepo.findById(id_b);
		User userTemp = userRepo.findById(id_u);
	
		if(bookTemp != null && userTemp != null) {
			model.addAttribute("User", userTemp);
			model.addAttribute("Book", bookTemp);
			
			return "bookviewemployee";
		}
		else {
			return "error";
		}
		
		
	}
	
	
	
	//jaunas gramatas pievienosanas skats
	@GetMapping(value = "/addBook/{id}")
	public String addBook(Model model, Book book, @PathVariable(name = "id") int id){
		User userTemp = userRepo.findById(id);
		
		if(userTemp != null) {
			model.addAttribute("User", userTemp);
			return "addbook";
		}
		else {
			return "error";
		}
		
	}
	
	
	@PostMapping(value = "/addBook/{id}")
	public String addBookPost(Model model, Book book, @PathVariable(name = "id") int id){
		LibraryDepartment depart = libraryDepartmentRepo.findByTitle(book.getDepartment().getTitle());
		Book bookTemp = bookRepo.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
		if(depart != null) {
			if(bookTemp == null){
				Book newBook  = book;
				newBook.setDepartment(depart);
				bookRepo.save(newBook);
				return "redirect:/homeEmployee/" + id;
			}
				
			else if(bookTemp.getCoppies() >= 1 && bookTemp.getCoppies() < 5) {
				bookTemp.addCopy();
				bookRepo.save(bookTemp);
				return "redirect:/homeEmployee/" + id;
			}
				
			else{
				return "addbookfail";
			}
		}
		else {
			return "error";
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
	//skaisti
	//labs
	
}