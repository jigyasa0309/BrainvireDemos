package com.springcore.stereotype;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
	@Value("jigyasa")
private String name;
	@Value("indore")
private String city;
	@Value("#{mylist}")
	private List<String> friends;
	
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getFriends() {
	return friends;
}
public void setFriends(List<String> friends) {
	this.friends = friends;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Student [name=" + name + ", city=" + city + ", friends=" + friends + "]";
}

}
