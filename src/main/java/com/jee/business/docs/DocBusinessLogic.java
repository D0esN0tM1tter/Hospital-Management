package com.jee.business.docs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jee.Models.Document;

public interface DocBusinessLogic {

    public int insertDocument(Document document);
    public Document selectDocument(int docId) throws FileNotFoundException, IOException ;
    public void updateDocument(int documentid, Document updatedDocument) throws SQLException;
    public int deleteDocument(int docId) throws SQLException;
    public List<Document> selecByPidAndType(int patientId, String docType);
}
