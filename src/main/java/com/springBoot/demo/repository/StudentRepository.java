package com.springBoot.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.demo.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public List<Student> findAll();

}
