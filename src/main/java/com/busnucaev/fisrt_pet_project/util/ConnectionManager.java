package com.busnucaev.fisrt_pet_project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String username = "postgres";
    private static final String password = "postgres";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";

    private ConnectionManager(){
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username,password);
    }

}
