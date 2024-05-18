package com.jee.dao.manager;

import java.sql.SQLException;
import java.util.List;

import com.jee.Models.Document;

public interface DaoLogic {
    public int insert(Object o);
    
    public Object select(int id);

    public String delete(int id) throws SQLException;
    public List<Document> selecByPidAndType(int patientId , String docType);

    public String getDocumentType(int documentid) throws SQLException;
	public void updateDocument(int documentId, Document updatedDocument) throws SQLException ;
    public String selectPath(int docId) ;
	public int update(Object o);
	public int verify(String login, String password);


}
