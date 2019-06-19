package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Reader;
import com.example.demo.model.User;

public interface ReaderRepo extends CrudRepository<Reader, Integer> {
	
	Reader findByNameAndSurname(String name, String surname);
	Reader findById(int id_r);
	Reader findByUserRead(User user);
	
}
