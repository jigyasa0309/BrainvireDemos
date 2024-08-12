package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TrainTest {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"com/springcore/lifecycle/lifecycleconfig.xml");
	//	System.out.println(context.getBean("train"));
	 	context.registerShutdownHook();
		System.out.println("-----------------------------------------------------");
		System.out.println(context.getBean("game"));
		System.out.println("-----------------------------------------------------");
		System.out.println(context.getBean("food"));
		
	}

}
