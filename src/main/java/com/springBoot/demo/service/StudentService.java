package com.springBoot.demo.service;

import java.util.List;
import java.util.Optional;

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

	public void add(Student student) {
		studentRepository.save(student);
	}

	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
	}

	public Student updateStudent(int id, Student updatedStudent) {
		Student students = studentRepository.findById(id)
				.map(
					student ->{
						student.setName(updatedStudent.getName());
						student.setCourse(updatedStudent.getCourse());
						student.setSubject(updatedStudent.getCourse());
						return studentRepository.save(student);
				}).orElse(null);

		return students;
	}

	public void removeEmployee(int id) {
		studentRepository.deleteById(id);
	}
}
