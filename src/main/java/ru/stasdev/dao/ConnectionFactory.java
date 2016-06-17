package ru.stasdev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";

    private static ConnectionFactory instance;

    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){throw new RuntimeException("Not found class"+DRIVER,e);
        }
    }

    public static synchronized ConnectionFactory getInstance(){
        if(instance == null){
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
    }
}
