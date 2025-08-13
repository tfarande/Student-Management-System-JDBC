package practice;

import java.sql.*;
import java.util.Scanner;

public class GetConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        System.out.println("enter id, name and marks");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String name = sc.next();
        int mark = sc.nextInt();

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url,username,password);

        String query = "insert into TB values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setInt(3,mark);

        preparedStatement.executeUpdate();
        System.out.println("records added successfully");
        connection.close();
    }
}
