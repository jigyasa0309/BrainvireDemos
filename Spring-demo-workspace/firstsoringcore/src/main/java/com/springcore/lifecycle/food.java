package com.springcore.lifecycle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class food {
private String typess;

public String getTypess() {
	return typess;
}

public void setTypess(String typess) {
	this.typess = typess;
}

@Override
public String toString() {
	return "food [typess=" + typess + "]";
}

public food(String typess) {
	super();
	this.typess = typess;
}

public food() {
	super();
	// TODO Auto-generated constructor stub
}

@PostConstruct
public void start() {
	System.out.println("init");
}
@PreDestroy

public void end() {
	System.out.println("destroy");
}
}
