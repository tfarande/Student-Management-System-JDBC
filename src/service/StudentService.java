package service;

import dao.StudentDao;
import model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();

    public void addStudent(Student student)  {

        studentDao.addRecords(student);

    }

    public List<Student> getAllStudent(){

        return studentDao.getAllStudent();
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    public void updateRecords(Student student)  {

        studentDao.updateRecords(student);

    }
}
