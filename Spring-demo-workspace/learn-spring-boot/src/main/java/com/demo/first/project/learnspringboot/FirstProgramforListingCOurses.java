package com.demo.first.project.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FirstProgramforListingCOurses {
	@RequestMapping("/courses")
public List<Courses> showAll(){
	return Arrays.asList(
			new Courses(1,"learn java","abdul"),
			new Courses(2,"learn dsa","we2code"),
			new Courses(3,"learn java 8","Durga")
			);
}
}
