package com.spring.orm.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// Other methods and properties...

	// for saving student
	@Transactional // Add this annotation to enable transaction management
	public int insert(Student student) {
		hibernateTemplate.setCheckWriteOperations(false); // Disable read-only mode

		Integer i = (Integer) this.hibernateTemplate.save(student);
		hibernateTemplate.setCheckWriteOperations(true); // Disable read-only mode

		return i;
	}

	@Transactional // Add this annotation to enable transaction management
	public void update(Student student) {
		hibernateTemplate.setCheckWriteOperations(false); // Disable read-only mode

		this.hibernateTemplate.update(student);
		hibernateTemplate.setCheckWriteOperations(true); // Disable read-only mode

		System.out.println("updated ");

	}

	// getting one object
	public Student getStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}

	// get all ovject
	public List<Student> getAllStudent() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}

	@Transactional // Add this annotation to enable transaction management
	public void delete(int id) {
		hibernateTemplate.setCheckWriteOperations(false); // Disable read-only mode
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
		hibernateTemplate.setCheckWriteOperations(true); // Disable read-only mode
		System.out.println("deleted");

	}

}
