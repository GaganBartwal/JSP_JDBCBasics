package com.bartwal.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDataServices {

    public Connection mySQLConnection(){

        Connection connection = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/socialapp";
            String username = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, username, password);

        }catch(Exception e){
            e.printStackTrace();
        }

        return connection;

    }
}
