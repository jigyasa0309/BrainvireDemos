package com.springcore.firstspringcore.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
private String name;
private List<String> phones;
private Set<String > adresses;
private Map<String , String > courses;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getPhones() {
	return phones;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public void setPhones(List<String> phones) {
	this.phones = phones;
}
public Set<String> getAdresses() {
	return adresses;
}
public void setAdresses(Set<String> adresses) {
	this.adresses = adresses;
}
public Map<String, String> getCourses() {
	return courses;
}
public void setCourses(Map<String, String> courses) {
	this.courses = courses;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", phones=" + phones + ", adresses=" + adresses + ", courses=" + courses + "]";
}
public Employee(String name, List<String> phones, Set<String> adresses, Map<String, String> courses) {
	super();
	this.name = name;
	this.phones = phones;
	this.adresses = adresses;
	this.courses = courses;
}

}
