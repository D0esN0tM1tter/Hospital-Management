package com.jee.Models;

public class Doctor {
private String name ;
private String firstname;
private String login;
private String password;
private int id ;
public Doctor() {}
public Doctor(String name, String firstname, String login, String password) {
	this.name = name;
	this.firstname = firstname;
	this.login = login;
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String toString() {
	return "doctor [name=" + name + ", firstname=" + firstname + ", login=" + login + ", password=" + password + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


}
