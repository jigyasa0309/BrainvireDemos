package com.springcore.firstspringcore.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testcollection {
public static void main(String[] args) {
	ApplicationContext context =
    		new ClassPathXmlApplicationContext("com/springcore/firstspringcore/collection/collectionconfig.xml"); 
  Employee emp=  (Employee) context.getBean("emp");
  System.out.println(emp);
}
}
