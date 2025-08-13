package controller;

import model.Student;
import service.StudentService;

import java.util.List;

public class StudentController {

    StudentService service = new StudentService();

    public void addStudent(Student student)  {
        service.addStudent(student);
    }

    public List<Student> getAllStudent(){

        return service.getAllStudent();
    }

    public void deleteStudent(int id) {

        service.deleteStudent(id);
    }

    public void updateRecords(Student student)  {

        service.updateRecords(student);

    }
}
