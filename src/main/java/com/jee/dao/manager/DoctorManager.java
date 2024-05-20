package com.jee.dao.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jee.dao.connection.MySQLDataSource;
import com.jee.dao.connection.SQLDataSource;
import com.jee.Models.Doctor;
import com.jee.Models.Document;

public class DoctorManager implements DaoLogic {

    private SQLDataSource ds;
    private Connection cnc;

    public DoctorManager(MySQLDataSource ds) {
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
        String sql = "INSERT INTO Doctor (name, firstname, login, password) VALUES (?, ?, ?, ?)";
        try ( 
             PreparedStatement stmt = cnc.prepareStatement(sql)) {
            // Utilisation de PreparedStatement pour éviter les injections SQL
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getFirstname());
            stmt.setString(3, doctor.getLogin());
            stmt.setString(4, doctor.getPassword());

            // Exécution de la requête
            rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }


    @Override
    public Object select(int id) {
        Doctor doctor = null;
        String sql = "SELECT * FROM doctor WHERE id = ?";
        try (PreparedStatement stmt = cnc.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setId(id);
                doctor.setName(rs.getString("Name"));
                doctor.setFirstname(rs.getString("Firstname"));
                doctor.setLogin(rs.getString("Login"));
                doctor.setPassword(rs.getString("Password"));

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
        String sql = "UPDATE doctor SET fname=?, lname=? WHERE id=?";
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
        String query = "DELETE FROM doctor WHERE id = ?";
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
	public void updateDocument(int documentId,  String newPath
    ) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public int verify(String login, String password) {
	    try {
	        String sql = "SELECT * FROM doctor WHERE login = ? AND password = ?";
	        
	        PreparedStatement pstmt = this.cnc.prepareStatement(sql);
	        
	        // Attribution des valeurs des paramètres
	        pstmt.setString(1, login);
	        pstmt.setString(2, password);
	        
	        // Exécution de la requête
	        ResultSet rs = pstmt.executeQuery();

	        // Si la requête renvoie un résultat, alors l'utilisateur existe
	        if (rs.next()) {
	            // Fermeture des ressources
	            rs.close();
	            pstmt.close();
	            // Retourne 1 pour indiquer que l'utilisateur est trouvé
	            return 1;
	        } else {
	            // Fermeture des ressources
	            rs.close();
	            pstmt.close();
	            // Retourne -1 pour indiquer que l'utilisateur n'est pas trouvé
	            return -1;
	        }
	    } catch (SQLException e) {
	        // Gestion des exceptions
	        e.printStackTrace();
	        // Retourne 0 en cas d'erreur
	        return 0;
	    }
	}

    @Override
    public String selectPath(int docId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectPath'");
    }

}
