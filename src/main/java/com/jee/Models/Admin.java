package com.jee.Models;

public class Admin {
	
	   private int id;
	   private String firstname;
	   private String lastname;
	   private String username;
	   private String passwd;

	   
	   
	   
	public Admin(String firstname,String lastname,String username, String passwd) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.username = username;
		this.passwd = passwd;
	}


	public Admin() {
		//TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	  

}
