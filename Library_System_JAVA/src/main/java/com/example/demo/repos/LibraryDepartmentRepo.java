package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.LibraryDepartment;

public interface LibraryDepartmentRepo extends CrudRepository<LibraryDepartment, Integer> {

	LibraryDepartment findByTitle(String title);
	
}
