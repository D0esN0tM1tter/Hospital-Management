package com.jee.dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jee.dao.connection.SQLDataSource;
import com.jee.Models.Document;

public class DocumentManager implements CrudInterfaceDao {

    private SQLDataSource ds;
    private Connection cnc;

    public DocumentManager(SQLDataSource ds) {
        this.ds = ds;
        this.cnc = this.ds.getConnection();
    }

    @Override
    public int insert(Object obj) {
        if (!(obj instanceof Document)) {
            throw new IllegalArgumentException("Object must be of type Document");
        }
        Document document = (Document) obj;
        int rowsAffected = 0;
        String sql = "INSERT INTO hospital.document VALUES (? , ? , ? , ? , ? , ?)";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, document.getId());
            stmt.setInt(2, document.getPatientId());
            stmt.setString(3, document.getDocType());
            stmt.setString(4 , document.getPath());
            stmt.setTimestamp(5, document.getToc());
            stmt.setString(6, document.getDescription());

            System.err.println("Record inserted successfully.");
            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }


    @Override
    public Object select(int id) {
        Document document = null;
        String sql = "SELECT * FROM hospital.document WHERE id = ?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                document = new Document();
                document.setId(rs.getInt("id"));
                document.setPatientId(rs.getInt("patientId"));
                document.setDocType(rs.getString("docType"));
                document.setPath(rs.getString("path"));
                document.setToc(rs.getTimestamp("toc"));
                document.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return document;
    }


    @Override
    public int update(Object obj) {
        if (!(obj instanceof Document)) {
            throw new IllegalArgumentException("Object must be of type Document");
        }
        Document document = (Document) obj;
        int rowsAffected = 0;
        String sql = "UPDATE documents SET patientId=?, docType=?, path=?, toc=? , description = ? WHERE id=?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, document.getPatientId());
            stmt.setString(2, document.getDocType());
            stmt.setString(3, document.getPath());
            stmt.setTimestamp(4, document.getToc());
            stmt.setInt(5, document.getId());
            stmt.setString(6, document.getDescription());
            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }




   public String selectPath(int docId) {
        // Initialize the path : 
        String path = null ; 
        
        //Formulating the query : 
        String query = "SELECT path FROM document WHERE id = ?" ; 

        //Creating a statement and execute : 
        try(PreparedStatement stmt = this.cnc.prepareStatement(query)) {
            // Set the parameters of the statement : 
            stmt.setInt(1, docId);
            // Getting the result of the query : 
            ResultSet rs = stmt.executeQuery() ; 

            if (rs.next()) {
                path = rs.getString("path");
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return path ; 
   }

@Override
public String delete(int id) throws SQLException {
    // Getting the path of the specified document : 
    String path = selectPath(id) ; 
    int rowsAffected = 0;
    // Formulating the query : 
    String query = "DELETE FROM document WHERE id = ?";
    // Creating a statement and execute : 
    try(PreparedStatement stmt = this.cnc.prepareStatement(query)) {
        //Setting the parameters for the statement : 
        stmt.setInt(1, id);
        rowsAffected = stmt.executeUpdate() ; 

        if (rowsAffected >0) {
            System.out.println("Document deleted successfully");
        }
        else {
            System.out.println("Cannot delete document");
        }

    }catch(Exception e ) {
        e.printStackTrace();
    }


    return path ;
}

@Override
public List<Object> selecByPidAndType(int patientId, String docType) {

    // initializing the list : 
    List<Object> list = new ArrayList<>() ;

    // 1 : formulate the query : 
    String query = "SELECT * FROM document JOIN patient ON document.patientId = patient.id WHERE document.type = ? ";
    //2 : Creating a statement :
    try(PreparedStatement stmt = this.cnc.prepareStatement(query)) {
        // Setting the parameter of the parameter of the query : 
        stmt.setString(1, query);
        // Creating a resultset : 
        ResultSet rs = stmt.executeQuery() ; 

        while (rs.next()) {
            Document doc = new Document() ; 
            doc.setId(rs.getInt("id"));
            doc.setDocType(rs.getString("doctype"));
            doc.setPath(rs.getString("path"));
            doc.setToc(rs.getTimestamp("toc"));
            doc.setDescription(rs.getString("description"));

            list.add(doc);
        }
    }catch(Exception e) {
        e.printStackTrace();
    }

    return list ;
}

    

        
    }


