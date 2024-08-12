package com.springcore.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RefernceObject {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	ApplicationContext context =new ClassPathXmlApplicationContext("com/springcore/reference/refconfig.xml"); 
	  A referenceA=  (A) context.getBean("referenceA");
	  System.out.println(referenceA);
	}

}
