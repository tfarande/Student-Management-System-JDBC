package dao;

import model.Student;
import util.JdbcConnectionUtil;

import java.sql.*;
import java.util.*;

public class StudentDao {

    public void addRecords(Student student)  {

        Connection connection = JdbcConnectionUtil.getConnection();

        String query = "insert into TB(id,name,marks) values(?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getMarks());

            preparedStatement.executeUpdate();
            System.out.println("Student added successfully");

        } catch (SQLException e){
            System.out.println("query x");

        }

    }

    public List<Student> getAllStudent(){

        List<Student> list = new ArrayList<>();
        Connection connection = JdbcConnectionUtil.getConnection();
        String query = "select * from TB";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("marks"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       /* try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } */
        return list;
    }


    public void deleteStudent(int id)  {

        Connection connection = JdbcConnectionUtil.getConnection();
        String query = "delete from TB where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Record deleted successfully");
       /* try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } */
    }

    public void updateRecords(Student student)  {

        Connection connection = JdbcConnectionUtil.getConnection();

        String query = "update TB set name =?, marks=? where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getMarks());
            preparedStatement.setInt(3, student.getId());

            preparedStatement.executeUpdate();
            System.out.println("Student Record updated successfully");

        } catch (SQLException e){
            System.out.println("query x");

        }

    }


}
