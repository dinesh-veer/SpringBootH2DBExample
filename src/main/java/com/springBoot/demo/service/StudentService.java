package com.springBoot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.demo.model.Student;
import com.springBoot.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudentList(){
		return studentRepository.findAll();
	}
 
}
