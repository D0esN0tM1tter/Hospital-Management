package com.jee.business.docs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.jee.Models.Document;

public interface DocumentService {

    public int insertDocument(Document document);
    public Document selectDocument(int docId) throws FileNotFoundException, IOException ;
    public void updateDocument(int documentid, Document updatedDocument) throws SQLException;
    public int deleteDocument(int docId) throws SQLException;

}
