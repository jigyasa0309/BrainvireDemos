package com.spingcore.spEl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spingcore/spEl/spelconfig.xml");
        Student student = context.getBean(Student.class);

        System.out.println(student);
    }
}
