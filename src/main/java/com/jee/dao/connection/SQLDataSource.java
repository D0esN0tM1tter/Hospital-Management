package com.jee.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLDataSource {
	
	protected String driver;
	protected String url;
	protected String user;
	protected String password;
	
	public SQLDataSource() {
	}

	public SQLDataSource(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public SQLDataSource(String driver , String url) {
		this.driver = driver ; 
		this.url = driver ; 
	}


	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConnection() {
		try {
			Class.forName(driver);
			System.out.println("Connection with the server is established.");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
