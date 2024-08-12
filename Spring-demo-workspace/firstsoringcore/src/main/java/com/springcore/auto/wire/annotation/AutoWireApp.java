package com.springcore.auto.wire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/auto/wire/annotation/autoconfig.xml");

        // Autowiring by Name
        Employee employeeByName = context.getBean("employeeByName", Employee.class);
        System.out.println("Autowired by Name: " + employeeByName);

        // Autowiring by Type
        Employee employeeByType = context.getBean("employeeByType", Employee.class);
        System.out.println("Autowired by Type: " + employeeByType);

        // Constructor-Based Autowiring
        Employee employeeConstructor = context.getBean("employeeConstructor", Employee.class);
        System.out.println("Constructor-Based Autowiring: " + employeeConstructor);
    }
}
