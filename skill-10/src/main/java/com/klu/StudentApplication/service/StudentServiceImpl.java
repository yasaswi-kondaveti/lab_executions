package com.klu.StudentApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.klu.StudentApplication.model.Student;
import com.klu.StudentApplication.repository.StudentRepository;

public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentrepo;

	@Override
	public Student saveUser(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
	}

	@Override
	public List<Student> getAllUsers() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	@Override
	public Student getUserById(int sid) {
		// TODO Auto-generated method stub
		return studentrepo.getById(sid);
	}

	@Override
	public void deleteUser(int sid) {
		// TODO Auto-generated method stub
		studentrepo.deleteById(sid);
		
	}

}
