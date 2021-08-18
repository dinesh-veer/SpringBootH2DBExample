package com.springBoot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.demo.model.Student;
import com.springBoot.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService StudentService;
	
	@GetMapping(path = "/student")
	public List<Student> getAllStudents() {
		return StudentService.getStudentList();
	}
}

