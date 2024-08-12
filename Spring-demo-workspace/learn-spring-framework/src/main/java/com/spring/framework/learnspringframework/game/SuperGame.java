package com.spring.framework.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperGame implements GamingConsole{

public void up() {
	System.out.println("super up");
}
public void down() {
System.out.println("super down");	
}
public void left() {
	System.out.println("super left");
}
public void right() {
	System.out.println("super right");
}



}
