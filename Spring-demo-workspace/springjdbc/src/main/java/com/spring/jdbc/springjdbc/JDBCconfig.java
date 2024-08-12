package com.spring.jdbc.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.springjdbc.dao.StudentDAO;
import com.spring.jdbc.springjdbc.dao.StudentDAOImpl;

@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.springjdbc")

public class JDBCconfig {
	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/SprngJDBC");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

	@Bean("studentDao")
	public StudentDAO getStudentDao() {
		StudentDAOImpl studentDao = new StudentDAOImpl();
		studentDao.setJdbctemplate(getTemplate());
		return studentDao;
	}
}
