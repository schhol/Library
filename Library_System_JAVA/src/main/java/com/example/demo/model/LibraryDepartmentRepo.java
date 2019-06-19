package com.example.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface LibraryDepartmentRepo extends CrudRepository<LibraryDepartment, Integer> {

	LibraryDepartment findByTitle(String title);
	
}
