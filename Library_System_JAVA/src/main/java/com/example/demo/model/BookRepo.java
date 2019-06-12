package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer> {

	Book findByTitleAndAuthor(String title, String author);
	
}
