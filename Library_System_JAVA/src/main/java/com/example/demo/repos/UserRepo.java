package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);
	User findById(int id_u);
	
}
