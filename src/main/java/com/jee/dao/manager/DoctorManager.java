package com.jee.dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jee.dao.connection.SQLDataSource;
import com.jee.Models.Doctor;
import com.jee.Models.Document;

public class DoctorManager implements CrudInterfaceDao {

    private SQLDataSource ds;
    private Connection cnc;

    public DoctorManager(SQLDataSource ds) {
        this.ds = ds;
        this.cnc = this.ds.getConnection();
    }

    @Override
    public int insert(Object obj) {
        if (!(obj instanceof Doctor)) {
            throw new IllegalArgumentException("Object must be of type Doctor");
        }
        Doctor doctor = (Doctor) obj;
        int rowsAffected = 0;
        String sql = "INSERT INTO doctors VALUES (?, ?, ?)";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getFirstname());
            stmt.setString(3, doctor.getLogin());
            stmt.setString(3, doctor.getPassword());

            rowsAffected = stmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public Object select(int id) {
        Doctor doctor = null;
        String sql = "SELECT * FROM doctors WHERE id = ?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setName(rs.getString("Name"));
                doctor.setFirstname(rs.getString("Firstname"));
                doctor.setLogin(rs.getString("Login"));
                doctor.setPassword("Password");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctor;
    }

    @Override
    public int update(Object obj) {
        if (!(obj instanceof Doctor)) {
            throw new IllegalArgumentException("Object must be of type Doctor");
        }
        Doctor doctor = (Doctor) obj;
        int rowsAffected = 0;
        String sql = "UPDATE doctors SET fname=?, lname=? WHERE id=?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
        	stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getFirstname());
            stmt.setString(3, doctor.getLogin());
            stmt.setString(3, doctor.getPassword());

            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public String delete(int id) throws SQLException {
        String query = "DELETE FROM doctors WHERE id = ?";
        try (PreparedStatement stm = cnc.prepareStatement(query)) {
            stm.setInt(1, id);
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                return "Doctor with ID " + id + " deleted successfully.";
            } else {
                return "Doctor with ID " + id + " not found.";
            }
        }
    }

    @Override
    public List<Document> selecByPidAndType(int patientId, String docType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByPidAndType'");
    }

	@Override
	public String getDocumentType(int documentid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDocument(int documentId, Document updatedDocument) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public int verify(String login, String password) {
		try {
			String sql = "SELECT COUNT(*) AS count_docteur FROM docteur WHERE login = '" + login + "' AND password = '" + password + "'";
		    int count = 0;

		         Statement stmt = this.cnc.createStatement();
		         ResultSet rs = stmt.executeQuery(sql) ;

		        if (rs.next()) {
		            count = rs.getInt("count_docteur");
		            return count;
		        }
		         return -1;
		    } catch (Exception e) {
		        e.printStackTrace(); 
		        return -1;
		    }
}}
