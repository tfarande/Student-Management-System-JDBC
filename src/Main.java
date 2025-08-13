import controller.StudentController;
import model.Student;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {


        int ch;
        StudentController studentController = new StudentController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: \n1.Insert student records \n2.Delete a particular student \n3." +
                "Update Student Record \n4.Display all records");
        ch = sc.nextInt();

        switch (ch){
            case 1 :
                System.out.println("Enter student id , name and marks");
                int id = sc.nextInt();
                String name = sc.next();
                int marks = sc.nextInt();
                Student student = new Student(id,name,marks);
                studentController.addStudent(student);
                break;
            case 2 :
                System.out.println("Enter student id which is to be updated");
                int id3 = sc.nextInt();
                studentController.deleteStudent(id3);
                break;
            case 3 :
                System.out.println("Enter student id, name and marks which is to be updated");
                int id1 = sc.nextInt();
                String name1 = sc.next();
                int marks1 = sc.nextInt();
                Student student1 = new Student(id1,name1,marks1);
                studentController.updateRecords(student1);
                break;
            case 4 :
                List<Student> allstudents = studentController.getAllStudent();
                allstudents.forEach(System.out::println);
                break;
            default:
                System.out.println("record not found");
                break;

        }


    }
}