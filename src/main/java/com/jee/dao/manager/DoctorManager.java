package com.jee.dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jee.dao.connection.SQLDataSource;
import com.jee.Models.Doctor;

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
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, doctor.getFname());
            stmt.setString(3, doctor.getLname());
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
                doctor.setId(rs.getInt("id"));
                doctor.setFname(rs.getString("fname"));
                doctor.setLname(rs.getString("lname"));
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
            stmt.setString(1, doctor.getFname());
            stmt.setString(2, doctor.getLname());
            stmt.setInt(3, doctor.getId());
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
    public List<Object> selecByPidAndType(int patientId, String docType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByPidAndType'");
    }
}
