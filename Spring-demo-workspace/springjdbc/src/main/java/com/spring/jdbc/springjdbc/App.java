package com.spring.jdbc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.springjdbc.dao.StudentDAO;

public class App {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JDBCconfig.class);
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("com/spring/jdbc/springjdbc/config.xml");
		/*
		 * JdbcTemplate temp= context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * 
		 * //insert String query =
		 * "INSERT INTO student (id,name,address) values(?,?,?)"; int result=
		 * temp.update(query,3,"Barbie","Lucknow");
		 * System.out.println("Number of record inserted "+result);
		 */

		/*
		 * //inserting StudentDAO studentDao
		 * =context.getBean("studentDao",StudentDAO.class); Student student=new
		 * Student(); student.setId(2); student.setAddress("devas");
		 * student.setName("Harshit"); int result=studentDao.insert(student);
		 * System.out.println(result);
		 */

		/*
		 * //updating value StudentDAO studentDao
		 * =context.getBean("studentDao",StudentDAO.class); Student student=new
		 * Student(); student.setId(2); student.setAddress("Devas");
		 * student.setName("Harshit"); int result=studentDao.update(student);
		 * System.out.println(result);
		 */

//delete
		/*
		 * StudentDAO studentDao =context.getBean("studentDao",StudentDAO.class);
		 * Student student=new Student(); int result=studentDao.delete(2);
		 * System.out.println(result);
		 */
		System.out.println("<<<<------Listing Multiple Records-------->>>>>");
		StudentDAO studentDao = context.getBean("studentDao", StudentDAO.class);
		Student student = new Student();

		List<Student> students = studentDao.listStudents();

		for (Student record : students) {
			System.out.println(record);

			/*
			 * ApplicationContext con = new
			 * AnnotationConfigApplicationContext(JDBCconfig.class); StudentDAO studentDao =
			 * con.getBean("studentDao", StudentDAO.class);
			 * 
			 * Scanner scanner = new Scanner(System.in);
			 * 
			 * System.out.print("Enter student ID: "); int id = scanner.nextInt();
			 * scanner.nextLine();
			 * 
			 * System.out.print("Enter student name: "); String name = scanner.nextLine();
			 * 
			 * System.out.print("Enter student address: "); String address =
			 * scanner.nextLine();
			 * 
			 * Student student = new Student(id, name, address);
			 * 
			 * int result = studentDao.insert(student);
			 * System.out.println("Number of records inserted: " + result);
			 * 
			 * scanner.close();
			 */

		}
	}

}
