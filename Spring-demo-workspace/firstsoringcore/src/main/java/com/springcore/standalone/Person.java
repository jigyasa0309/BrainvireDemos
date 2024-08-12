package com.springcore.standalone;

import java.util.List;
import java.util.Map;

public class Person {
private List<String> friends;
private Map<String,String>Course;

public Map<String, String> getCourse() {
	return Course;
}

public void setCourse(Map<String, String> course) {
	Course = course;
}

public List<String> getFriends() {
	return friends;
}

public void setFriends(List<String> friends) {
	this.friends = friends;
}

@Override
public String toString() {
	return "Person [friends=" + friends + ", Course=" + Course + "]";
}

}
