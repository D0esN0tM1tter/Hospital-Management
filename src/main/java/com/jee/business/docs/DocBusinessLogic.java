package com.jee.business.docs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jee.Models.Document;

import jakarta.servlet.http.Part;

public interface DocBusinessLogic {

    public int insertDocument(Document document , Part p);
    public Document selectDocument(int docId) throws FileNotFoundException, IOException ;
    public void updateDocument(int documentid,  String newPath) throws SQLException;
    public int deleteDocument(int docId) throws SQLException;
    public List<Document> selecByPidAndType(int patientId, String docType);
}
