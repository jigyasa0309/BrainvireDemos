package com.spring.jdbc.springjdbc.dao;

import java.util.List;

import com.spring.jdbc.springjdbc.Student;

//maintiaing the loose coupling 
public interface StudentDAO {
	public int insert(Student student);

	public int update(Student student);

	public int delete(int id);

	public List<Student> listStudents();

}
