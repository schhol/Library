package com.example.demo.model;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer> {
	
	ArrayList<Book> findByOrderByTimesTakenDesc();

	Book findByTitleAndAuthor(String title, String author);
	
<<<<<<< HEAD
	Book findById(int id_b);
=======
	ArrayList<Book> findByTitle(String title);
	
	ArrayList<Book> findByAuthor(String author);
	
	ArrayList<Book> findByYear(int year);
	
>>>>>>> branch 'master' of https://github.com/schhol/Library.git
}
