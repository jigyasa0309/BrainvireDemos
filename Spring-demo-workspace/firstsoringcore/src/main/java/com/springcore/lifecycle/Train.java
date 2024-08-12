package com.springcore.lifecycle;

public class Train {
private String pnr;

public String getPnr() {
	return pnr;
}
public Train(String pnr) {
	super();
	this.pnr = pnr;
}
public Train() {
	super();
	// TODO Auto-generated constructor stub
}
public void setPnr(String pnr) {
	System.out.println("setting pnr value!!!");
	this.pnr = pnr;
}

@Override
public String toString() {
	return "Train [pnr=" + pnr + "]";
}
public void init() {
	System.out.println("init method");
}
public void destroy() {
	System.out.println("destroy method");
}

}
