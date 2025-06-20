package com.springBoot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springBoot.demo.model.Student;
import com.springBoot.demo.service.StudentService;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<HttpStatus> addStudent(@RequestBody Student student) {
		studentService.add(student);
		return ResponseEntity.status(HttpStatus.CREATED.value()).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id , @RequestBody Student student) {
		Student student1 = studentService.updateStudent(id,student);
		return student1==null?ResponseEntity.notFound().build():ResponseEntity.ok(student1);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) {
		studentService.removeEmployee(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED.value()).build();
	}
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getStudentList();
	}
}

