package com.springcore.standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context= new ClassPathXmlApplicationContext("com/springcore/standalone/standaloneconfig.xml");
Person person=(Person) context.getBean("person1");
System.out.println(person);
System.out.println(person.getFriends().getClass().getName());
System.out.println(person.getCourse().getClass().getName());

	}

}
