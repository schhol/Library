package com.example.demo.model;

//import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer> {
	
	//ArrayList<Book> findByOrderByTimesTakenDesc();

	Book findByTitleAndAuthor(String title, String author);
	
	Book findById(int id_b);
}
