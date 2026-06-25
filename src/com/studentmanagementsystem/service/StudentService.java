package src.com.studentmanagementsystem.service;

import java.util.Scanner;

import src.com.studentmanagementsystem.model.Department;
import src.com.studentmanagementsystem.model.Student;

public class StudentService {
    
    public Department dept = new Department("Computer Science");

    public void updateStudent(Scanner sc){
        System.out.print("Enter roll no to update: ");
        int rollUp = sc.nextInt(); sc.nextLine();
        Student stuUp = dept.findStudent(rollUp);
        if (stuUp != null) {
            Student updated = inputStudent(sc, rollUp);
            stuUp.update(updated.getName(), updated.getName(), 80, true, "Updated");
            System.out.println("Student updated!");
        } else System.out.println("Student not found!");
    }

     private Student inputStudent(Scanner sc, int roll) {
        System.out.print("Enter student name: ");
        String sName = sc.nextLine();
        System.out.print("Enter DOB (dd-mm-yyyy): ");
        String dob = sc.nextLine();
        System.out.print("Enter attendance %: ");
        int att = sc.nextInt(); sc.nextLine();
        System.out.print("Fees paid? (true/false): ");
        boolean fees = sc.nextBoolean(); sc.nextLine();
        System.out.print("Other personal details: ");
        String details = sc.nextLine();
        return new Student(sName, roll, dob, att, fees, details);
    }
}
