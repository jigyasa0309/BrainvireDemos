package Annotation;

import java.util.Scanner;

public class Employee {
	static Scanner sc=new Scanner(System.in);
	private int id;
	private String name;
	private String number;
	private String address;

//getter and setter 
	public int getId() {
	
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
	
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {

		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
	
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//toString method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", number=" + number + ", address=" + address + "]";
	}
//parameterised constructors

	public Employee(int id, String name, String number, String address) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.address = address;
	}
//default constructors

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
