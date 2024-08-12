package com.spring.springfirstproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import Annotation.DAO;
import Annotation.EmployeeInterface;

@Configuration
@ComponentScan(basePackages = "Annotation")
public class JAVAconfig {
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/SprngJDBC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public EmployeeInterface employeeDao(JdbcTemplate jdbcTemplate) {
        DAO dao = new DAO();
        dao.setJdbcTemplate(jdbcTemplate);
        return dao;
    }
}



