package com.klu.StudentApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.StudentApplication.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	
}	
