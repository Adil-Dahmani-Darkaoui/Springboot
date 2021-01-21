package com.webapp.microservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static Connection connection;

    private static void init() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/donjonsetdragons", "admin", "admin"
        );
    }


    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if(connection == null){
            init();
        }
        return connection;
    }
}
