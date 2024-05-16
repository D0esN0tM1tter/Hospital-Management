package com.jee.business.models;

import java.sql.SQLException;

public interface ModelBusinessLogic {
	
	public int insert(Object o);
	public Object select(int id );
	public int update (Object o);
	public String delete(int id ) throws SQLException;
	public boolean verify(String login, String password);

}
