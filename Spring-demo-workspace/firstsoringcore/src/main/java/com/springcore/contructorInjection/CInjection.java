package com.springcore.contructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CInjection {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	ApplicationContext context =new ClassPathXmlApplicationContext("com/springcore/contructorInjection/constructorcongif.xml");
	Person person= (Person)context.getBean("person");
	System.out.println(person);
}
}
