package com.springBoot.demo.service;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.springBoot.demo.model.Student;
import com.springBoot.demo.repository.StudentRepository;

@Service
@AllArgsConstructor
public class StudentService {

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
						student.setSubject(updatedStudent.getSubject());
						return studentRepository.save(student);
				}).orElse(null);

		return students;
	}

	public void removeEmployee(int id) {
		studentRepository.deleteById(id);
	}
}
