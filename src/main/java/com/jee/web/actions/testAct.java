package com.jee.web.actions;

import java.sql.SQLException;

import com.jee.business.facade.ApplicationFacade;

public class testAct {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
     DoctorAuth  a = new DoctorAuth(new ApplicationFacade());
     System.out.println(a.select(1));
	}

}
