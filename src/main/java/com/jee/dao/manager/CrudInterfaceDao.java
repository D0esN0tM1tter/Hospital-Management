package com.jee.dao.manager;

import java.sql.SQLException;
import java.util.List;

import com.jee.Models.Document;

public interface CrudInterfaceDao {
    public int insert(Object o);
    
    public Object select(int id);

    public String delete(int id) throws SQLException;
    public List<Object> selecByPidAndType(int patientId , String docType);

    public String getDocumentType(int documentid) throws SQLException;
	public void updateDocument(int documentId, Document updatedDocument) throws SQLException ;

}
