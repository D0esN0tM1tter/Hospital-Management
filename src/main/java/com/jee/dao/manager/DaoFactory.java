package com.jee.dao.manager;

import java.sql.SQLException;
import com.jee.dao.connection.MySQLDataSource;
import com.jee.dao.connection.SQLDataSource;

public class DaoFactory {

    public static DaoLogic createManager(String entityName) throws SQLException {
        MySQLDataSource ds = new MySQLDataSource();
        
        switch (entityName) {
            case "Admin":
                return new AdminManager(ds);
            
            case "Doctor" : 
                return new DoctorManager(ds);
            
            case "Document" : 
                return new DocumentManager(ds);
            
            case "Patient" : 
                return new PatientManager(ds);
        
            default:
                throw new IllegalArgumentException("Invalid entity name");
        }
    }
}
