package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);
	
}
