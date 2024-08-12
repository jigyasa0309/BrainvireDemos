package com.demo.first.project.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CurrencyController {
	@Autowired
	private CurrencyService configuration;
	@RequestMapping("/currency-configuration")
public CurrencyService showAll(){
	return configuration ;

}
}