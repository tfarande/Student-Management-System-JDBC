package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {


    private static Connection connection;
       static {
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               String url = "jdbc:mysql://localhost:3306/db";
               String username = "root";
               String password = "root";
                connection = DriverManager.getConnection(url, username, password);
           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           } catch (SQLException e) {
               System.out.println("Driver not found");
           }

       }
       public static Connection getConnection(){
           return  connection;
       }

}
