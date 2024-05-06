package com.jee.dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jee.dao.connection.SQLDataSource;
import com.jee.Models.Admin;

public class AdminManager implements CrudInterfaceDao {

    private SQLDataSource ds;
    private Connection cnc;

    public AdminManager(SQLDataSource ds) {
        this.ds = ds;
        this.cnc = this.ds.getConnection();
    }

    @Override
    public int insert(Object obj) {
        if (!(obj instanceof Admin)) {
            throw new IllegalArgumentException("Object must be of type Admin");
        }
        Admin admin = (Admin) obj;
        int rowsAffected = 0;
        String sql = "INSERT INTO admins VALUES (?, ?, ?)";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, admin.getId());
            stmt.setString(2, admin.getUsername());
            stmt.setString(3, admin.getPasswd());
            rowsAffected = stmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public Object select(int id) {
        Admin admin = null;
        String sql = "SELECT * FROM admins WHERE id = ?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPasswd(rs.getString("passwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public int update(Object obj) {
        if (!(obj instanceof Admin)) {
            throw new IllegalArgumentException("Object must be of type Admin");
        }
        Admin admin = (Admin) obj;
        int rowsAffected = 0;
        String sql = "UPDATE admins SET username=?, passwd=? WHERE id=?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setString(1, admin.getUsername());
            stmt.setString(2, admin.getPasswd());
            stmt.setInt(3, admin.getId());
            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    @Override
    public String delete(int id) throws SQLException {
        String query = "DELETE FROM admins WHERE id = ?";
        try (PreparedStatement stm = cnc.prepareStatement(query)) {
            stm.setInt(1, id);
            int rowsAffected = stm.executeUpdate();
            if (rowsAffected > 0) {
                return "Admin with ID " + id + " deleted successfully.";
            } else {
                return "Admin with ID " + id + " not found.";
            }
        }
    }

    @Override
    public List<Object> selecByPidAndType(int patientId, String docType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selecByPidAndType'");
    }

}
