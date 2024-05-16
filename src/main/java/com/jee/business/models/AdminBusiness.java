package com.jee.business.models;

import java.sql.SQLException;

import com.jee.dao.manager.DaoLogic;

public class AdminBusiness implements ModelBusinessLogic {
    private DaoLogic manager ;


    public AdminBusiness(DaoLogic manager) {
        this.manager = manager;

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

    
    public boolean verify(String login, String password) {
		 if(manager.verify(login, password)==1) {
			 return true;
		 }
		 return false;
	 }

}
