package com.springcore.ambiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAddition {


public static void main(String[] args) {
	@SuppressWarnings("resource")
	ApplicationContext context =new ClassPathXmlApplicationContext("com/springcore/ambiguity/ambiguityconfig.xml");
	Addition a= (Addition)context.getBean("add");
	a.doSum();
	System.out.println(a);
}
}
