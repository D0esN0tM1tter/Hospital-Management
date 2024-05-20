package com.jee.dao.connection;

public class MySQLDataSource extends SQLDataSource{
	
	public MySQLDataSource(String host, String dbname, String user, String password) {
		super("com.mysql.cj.jdbc.Driver", "jdbc:mysql://" + host + "/" + dbname, user, password);
	}

	public MySQLDataSource() {
		super("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/hospital", "root", "");
	}
}
