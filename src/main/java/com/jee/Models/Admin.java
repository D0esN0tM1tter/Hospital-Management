package com.jee.Models;

public class Admin {
	
	   private int id;
	   private String username;
	   private String passwd;
	   // autres attributs, constructeurs, getters et setters
	   
	   
	public Admin(int id, String username, String passwd) {
		super();
		this.id = id;
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
	  
	
	
	

}
