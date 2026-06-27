package src.com.studentmanagementsystem.service;

import java.util.Scanner;

import src.com.studentmanagementsystem.model.Department;
import src.com.studentmanagementsystem.model.Student;

public class StudentService {

    private Department department;

    public StudentService(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void updateStudent(Scanner sc) {
        System.out.print("Enter roll no to update: ");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("Roll number is required.");
            return;
        }

        int rollUp;
        try {
            rollUp = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number.");
            return;
        }

        Student stuUp = department.findStudent(rollUp);
        if (stuUp != null) {
            Student updated = inputStudent(sc, rollUp);
            stuUp.update(updated.getName(), updated.getDob(), updated.getAttendance(), updated.isFeesPaid(), updated.getPersonalDetails());
            System.out.println("Student updated!");
        } else {
            System.out.println("Student not found!");
        }
    }

    private Student inputStudent(Scanner sc, int roll) {
        System.out.print("Enter student name: ");
        String sName = sc.nextLine().trim();
        System.out.print("Enter DOB (dd-mm-yyyy): ");
        String dob = sc.nextLine().trim();
        System.out.print("Enter attendance %: ");
        int att = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Fees paid? (true/false): ");
        boolean fees = Boolean.parseBoolean(sc.nextLine().trim());
        System.out.print("Other personal details: ");
        String details = sc.nextLine().trim();
        return new Student(sName, roll, dob, att, fees, details);
    }
}
