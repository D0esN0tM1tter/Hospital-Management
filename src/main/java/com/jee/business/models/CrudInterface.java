package com.jee.business.models;

import java.sql.SQLException;

public interface CrudInterface {
	
	public int insert(Object o);
	public Object select(int id );
	public int update (Object o);
	public String delete(int id ) throws SQLException;

}
