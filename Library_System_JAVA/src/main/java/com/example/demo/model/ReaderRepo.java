package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface ReaderRepo extends CrudRepository<Reader, Integer> {
	
	Reader findByNameAndSurname(String name, String surname);
	
}
