package src.com.studentmanagementsystem.menus;

import java.util.Scanner;

import src.com.studentmanagementsystem.model.Department;
import src.com.studentmanagementsystem.model.Faculty;
import src.com.studentmanagementsystem.model.Student;
import src.com.studentmanagementsystem.service.StudentService;

public class Menu {

    public static void adminMenu(Scanner sc, StudentService studentService) {
        Department dept = studentService.getDepartment();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add Faculty");
            System.out.println("6. View All Faculties");
            System.out.println("7. Update Faculty");
            System.out.println("8. Delete Faculty");
            System.out.println("9. Logout");
            System.out.print("Choice: ");

            int choice = parseChoice(sc);
            switch (choice) {
                case 1:
                    dept.addStudent(inputStudent(sc));
                    System.out.println("Student added.");
                    break;
                case 2:
                    dept.displayStudents();
                    break;
                case 3:
                    studentService.updateStudent(sc);
                    break;
                case 4:
                    System.out.print("Enter roll no to delete: ");
                    int rollDel = parseChoice(sc);
                    if (rollDel >= 0 && dept.removeStudent(rollDel)) {
                        System.out.println("Student deleted!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 5:
                    dept.addFaculty(inputFaculty(sc));
                    System.out.println("Faculty added.");
                    break;
                case 6:
                    dept.displayFaculties();
                    break;
                case 7:
                    System.out.print("Enter faculty name to update: ");
                    String fname = sc.nextLine().trim();
                    Faculty facUp = dept.findFaculty(fname);
                    if (facUp != null) {
                        Faculty updated = inputFaculty(sc);
                        facUp.update(updated.getName(), updated.getSubject());
                        System.out.println("Faculty updated!");
                    } else {
                        System.out.println("Faculty not found!");
                    }
                    break;
                case 8:
                    System.out.print("Enter faculty name to delete: ");
                    String fdel = sc.nextLine().trim();
                    if (dept.removeFaculty(fdel)) {
                        System.out.println("Faculty deleted!");
                    } else {
                        System.out.println("Faculty not found!");
                    }
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static void facultyMenu(Scanner sc, Department dept) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Faculty Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Logout");
            System.out.print("Choice: ");

            int choiceF = parseChoice(sc);
            switch (choiceF) {
                case 1:
                    dept.addStudent(inputStudent(sc));
                    System.out.println("Student added.");
                    break;
                case 2:
                    dept.displayStudents();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static void studentMenu(Scanner sc, Department dept) {
        System.out.print("Enter your roll no: ");
        int rollCheck = parseChoice(sc);
        if (rollCheck < 0) {
            System.out.println("Invalid roll number.");
            return;
        }

        Student s = dept.findStudent(rollCheck);
        if (s != null) {
            s.display();
        } else {
            System.out.println("Student not found!");
        }
    }

    private static int parseChoice(Scanner sc) {
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static Student inputStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String sName = sc.nextLine().trim();
        System.out.print("Enter roll no: ");
        int roll = parseChoice(sc);
        System.out.print("Enter DOB (dd-mm-yyyy): ");
        String dob = sc.nextLine().trim();
        System.out.print("Enter attendance %: ");
        int att = parseChoice(sc);
        System.out.print("Fees paid? (true/false): ");
        boolean fees = Boolean.parseBoolean(sc.nextLine().trim());
        System.out.print("Other personal details: ");
        String details = sc.nextLine().trim();
        return new Student(sName, roll, dob, att, fees, details);
    }

    private static Faculty inputFaculty(Scanner sc) {
        System.out.print("Enter faculty name: ");
        String fName = sc.nextLine().trim();
        System.out.print("Enter subject: ");
        String subj = sc.nextLine().trim();
        return new Faculty(fName, subj);
    }
}
