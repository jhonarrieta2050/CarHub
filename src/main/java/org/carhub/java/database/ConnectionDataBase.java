package org.carhub.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
   private static final String URL = "jdbc:mysql://localhost:3306/carHubapp";
   private static final String USER = "root";
   private static final String PASSWORD = "1042580716Jd!";

   public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(URL,USER,PASSWORD);
   }

}
