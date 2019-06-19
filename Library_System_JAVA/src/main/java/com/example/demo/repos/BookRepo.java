package com.example.demo.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Book;
import com.example.demo.model.LibraryDepartment;

public interface BookRepo extends CrudRepository<Book, Integer> {
	
	ArrayList<Book> findByOrderByTimesTakenDesc();

	Book findByTitleAndAuthor(String title, String author);
	
	Book findById(int id_b);

	ArrayList<Book> findByTitle(String title);
	
	ArrayList<Book> findByAuthor(String author);
	
	ArrayList<Book> findByYear(int year);
	
	ArrayList<Book> findByDepartment(LibraryDepartment department);

}
