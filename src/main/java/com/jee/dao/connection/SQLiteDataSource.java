package com.jee.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataSource extends SQLDataSource {

    public SQLiteDataSource() {
        super("org.sqlite.JDBC",
                "jdbc:sqlite:C:/Users/lahfa/OneDrive/Bureau/Main/Acadmics/Self-Learning/SQLite-databases/ecommerce.db");
    }

    @Override
    public Connection getConnection() {
        try {
            // Load the driver
            Class.forName(driver);

            // Return the connection
            return DriverManager.getConnection(url);

        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load the SQLite JDBC driver.");
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            System.err.println("Failed to connect to the SQLite database.");
            e.printStackTrace();
            return null;
        }
    }
}
