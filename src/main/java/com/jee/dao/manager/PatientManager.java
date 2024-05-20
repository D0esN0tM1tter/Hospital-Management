package com.jee.dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jee.dao.connection.SQLDataSource;
import com.jee.Models.Document;
import com.jee.Models.Patient;

public class PatientManager implements DaoLogic {

    private SQLDataSource ds;
    private Connection cnc;

    public PatientManager(SQLDataSource ds) {
        this.ds = ds;
        this.cnc = this.ds.getConnection();
    }

    @Override
    public int insert(Object obj) {
        if (!(obj instanceof Patient)) {
            throw new IllegalArgumentException("Object must be of type Patient");
        }
        Patient patient = (Patient) obj;
        int rowsAffected = 0;
        String sql = "INSERT INTO patient VALUES (?, ?, ?)";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, patient.getId());
            stmt.setString(2, patient.getFname());
            stmt.setString(3, patient.getLname());
            rowsAffected = stmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public Object select(int id) {
        Patient patient = null;
        String sql = "SELECT * FROM patient WHERE id = ?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setFname(rs.getString("fname"));
                patient.setLname(rs.getString("lname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public int update(Object obj) {
        if (!(obj instanceof Patient)) {
            throw new IllegalArgumentException("Object must be of type Patient");
        }
        Patient patient = (Patient) obj;
        int rowsAffected = 0;
        String sql = "UPDATE patient SET fname=?, lname=? WHERE id=?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setString(1, patient.getFname());
            stmt.setString(2, patient.getLname());
            stmt.setInt(3, patient.getId());
            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public String delete(int id) throws SQLException {
        String query = "DELETE FROM patient WHERE id = ?";
        try (PreparedStatement stm = cnc.prepareStatement(query)) {
            stm.setInt(1, id);
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                return "Patient with ID " + id + " deleted successfully.";
            } else {
                return "Patient with ID " + id + " not found.";
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
	public void updateDocument(int documentId,  String newPath) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int verify(String login, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
    public String selectPath(int docId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectPath'");
    }
}
