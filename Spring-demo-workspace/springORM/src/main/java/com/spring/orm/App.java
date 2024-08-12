package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		int id;
		String name;
		String address;
		Student student;
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("./config.xml");
		StudentDao studentdao = context.getBean("studentDao", StudentDao.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------welcome----------------");
		System.out.println("press 1 for insert----------------");
		System.out.println("press 2 for update----------------");
		System.out.println("press 3 for delete----------------");
		System.out.println("press 4 for read----------------");
		System.out.println("press 5 for reading all----------------");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("enter id");
			id = sc.nextInt();
			System.out.println("enter name");
			name = sc.next();
			System.out.println("enter address");
			address = sc.next();
			student = new Student(id, name, address);
			studentdao.insert(student);
			break;
		case 2:
			System.out.println("enter id");
			id = sc.nextInt();
			System.out.println("enter name");
			name = sc.next();
			System.out.println("enter address");
			address = sc.next();
			student = new Student(id, name, address);
			studentdao.update(student);
			break;
		case 3:
			System.out.println("enter id");
			id = sc.nextInt();
			studentdao.delete(id);
			break;
		case 4:
			System.out.println("enter id");
			id = sc.nextInt();
			Student stu = studentdao.getStudent(id);
			System.out.println(stu);

			break;
		case 5:
			List<Student> al = studentdao.getAllStudent();
			System.out.println(al);
			break;
		default:
			System.out.println("enter valid number");
			break;
		}
	}
}
