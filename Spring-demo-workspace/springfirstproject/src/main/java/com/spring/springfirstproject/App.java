package com.spring.springfirstproject;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Annotation.Employee;
import Annotation.EmployeeInterface;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(JAVAconfig.class);

		// Retrieve the EmployeeInterface bean (your DAO)
		EmployeeInterface employeeDao = context.getBean(EmployeeInterface.class);

		// Create a Scanner for user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter employee ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter employee name: ");
		String name = scanner.nextLine();
		System.out.print("Enter employee number: ");
		String number = scanner.nextLine();
		System.out.print("Enter employee address: ");
		String address = scanner.nextLine();
		Employee employee = new Employee(id, name, number, address);
		System.out.println("select any one option  1:insert , 2:update, 3:delete  ");
		int n = scanner.nextInt();
		switch (n) {
		case 1:
			System.out.println("you choose to insert");
			employeeDao.insert(employee);
			break;
		case 2:
			System.out.println("you choose to update");
			employeeDao.update(employee);
			break;
		case 3:
			System.out.println("you choose to delete");
			employeeDao.delete(id);
			break;
		default:
			System.out.println("enter the right choice");
		}

	}
}
