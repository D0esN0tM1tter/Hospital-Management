package com.jee.dao.manager;

import java.sql.SQLException;
import java.util.List;

public interface CrudInterfaceDao {
    public int insert(Object o);
    public Object select(int id);
    public int update(Object o);
    public String delete(int id) throws SQLException;
    public List<Object> selecByPidAndType(int patientId , String docType);

}
