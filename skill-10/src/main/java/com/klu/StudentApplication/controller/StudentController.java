package com.klu.StudentApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.StudentApplication.model.Student;
import com.klu.StudentApplication.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/students")
	Student saveUser(Student student) {
		return studentservice.saveUser(student);
	}
	
	@GetMapping("/students")
	List<Student> getAllUsers(){
		return studentservice.getAllUsers();
	}
	@GetMapping("/students/id")
	Student getUserById(int sid)
	{
		return studentservice.getUserById(sid);
	}
	
	@DeleteMapping("/students")
	void deleteUser(int sid) {
		
	}
}
