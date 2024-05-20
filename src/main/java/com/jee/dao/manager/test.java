package com.jee.dao.manager;

import java.sql.SQLException;

import com.jee.Models.Admin;
import com.jee.Models.Doctor;
import com.jee.dao.connection.MySQLDataSource;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub7
		Doctor dc = new Doctor("ayoub", "khezzaz", "ayoub", "ayoub123");
		DoctorManager docman = new DoctorManager(new MySQLDataSource());
		if(docman.verify("ayoub", "ayoub123") == 1) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		

	}

}
