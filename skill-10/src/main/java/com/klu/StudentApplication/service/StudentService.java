package com.klu.StudentApplication.service;

import java.util.List;

import com.klu.StudentApplication.model.Student;

public interface StudentService {
	Student saveUser(Student student);
	List<Student> getAllUsers();
	Student getUserById(int sid);
	void deleteUser(int sid);
	
}
