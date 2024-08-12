package com.spring.jdbc.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.springjdbc.Student;

public class StudentDAOImpl implements StudentDAO {
	private JdbcTemplate jdbctemplate;

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		// insert
		String query = "INSERT INTO student (id,name,address) values(?,?,?)";
		int r = this.jdbctemplate.update(query, student.getId(), student.getName(), student.getAddress());

		return r;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public int update(Student student) {

		String query = "UPDATE student set name=?, address=? where id=?";
		int r = this.jdbctemplate.update(query, student.getName(), student.getAddress(), student.getId());

		return r;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub

		String query = "Delete from student where id=?";
		int r = this.jdbctemplate.update(query, id);
		return r;
	}

	public List<Student> listStudents() {
		String SQL = "select * from student";
		List<Student> students = jdbctemplate.query(SQL, new StudentMapper());
		return students;

	}
}
