package com.springcore.auto.wire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employye {

private Address address;

@Override
public String toString() {
	return "Employye [address=" + address + "]";
}

public Address getAddress() {
	return address;
}
@Autowired
@Qualifier("address")
public void setAddress(Address address) {
	System.out.println("setter");
	this.address = address;
}

public Employye(Address address) {
	
	super();
//	System.out.println("contrucotr");
	this.address = address;
}

public Employye() {
	super();
	// TODO Auto-generated constructor stub
}

}
