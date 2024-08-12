package Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAO implements EmployeeInterface {
	@Autowired // Inject the JdbcTemplate
	private JdbcTemplate jdbcTemplate;

	// Setter method for JdbcTemplate
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Employee emp) {
		String query = "INSERT INTO emp (id, name, number, address) VALUES (?, ?, ?, ?)";
		int rowsAffected = jdbcTemplate.update(query, emp.getId(), emp.getName(), emp.getNumber(), emp.getAddress());

		if (rowsAffected > 0) {
			System.out.println("Employee record inserted successfully.");
		} else {
			System.out.println("Failed to insert employee record.");
		}
	}

	@Override
	public void update(Employee emp) {
		// Implement update logic here
		String query="UPDATE emp SET name=?, number=?, address=? WHERE id=?";
		int rowsAffected=jdbcTemplate.update(query,emp.getName(),emp.getNumber(),emp.getAddress(),emp.getId());
		if (rowsAffected > 0) {
			System.out.println("Employee record updated successfully.");
		} else {
			System.out.println("Failed to update employee record.");
		}
	}

	@Override
	public void delete(int id) {
		// Implement delete logic here
		String query="DELETE from emp where id=?";
		int rowsAffected=jdbcTemplate.update(query,id);
		if(rowsAffected>0) {
			System.out.println("Deleted Successfully ");}
			else 
				System.out.println("no record found");
	}
}
