package com.jee.business.models;

import java.sql.SQLException;

import com.jee.dao.manager.CrudInterfaceDao;
import com.jee.dao.manager.PatientManager;

public class PatientBusiness implements CrudInterface {
	CrudInterfaceDao manager ; 
	
	public PatientBusiness(PatientManager manager) {
		this.manager = manager ;
	}

	@Override
	public int insert(Object o) {
		return this.manager.insert(o);
	}

	@Override
	public Object select(int id) {
		return this.manager.select(id);
	}

	@Override
	public int update(Object o) {
		return this.manager.update(o);
	}

	@Override
	public String delete(int id) throws SQLException {
		return this.manager.delete(id);
	}

	


	
	

}