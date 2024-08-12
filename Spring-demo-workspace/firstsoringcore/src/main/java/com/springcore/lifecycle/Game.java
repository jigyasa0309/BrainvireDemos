package com.springcore.lifecycle;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Game implements InitializingBean,DisposableBean{
private String gname;
public Game() {
	super();
	// TODO Auto-generated constructor stub
}
public Game(String gname) {
	super();
	this.gname = gname;
}
@Override
public String toString() {
	return "Game [gname=" + gname + "]";
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
@Override
public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("init method: playing game");
	
}
@Override
public void destroy() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("in the destroy :game ended");
	
}
}
