package com.springcore.ambiguity;

public class Addition {
private double a;
private double b;
public Addition(int a,int b) {
	this.a=a;
	this.b=b;
	System.out.println("int constructor");
}
public Addition(double a,double b) {
	this.a=a;
	this.b=b;
	System.out.println("double constructor");
}

@Override
public String toString() {
	
	return "Addition [a=" + a + ", b=" + b + "]";
}
public void  doSum() {
	System.out.println("value of a is :"+a);

	System.out.println("value of b is:"+b);
	double sum=a+b;
	System.out.println(sum +"is the sum");
	
}
}
