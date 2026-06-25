package src.com.studentmanagementsystem.menus;

import java.util.Scanner;

import src.com.studentmanagementsystem.model.Department;
import src.com.studentmanagementsystem.model.Faculty;
import src.com.studentmanagementsystem.model.Student;
import src.com.studentmanagementsystem.service.StudentService;

public class Menu {
    
    public static Department dept = new Department("Computer Science");
    public static StudentService studentService = new StudentService();

    public static void adminMenu(Scanner sc){
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
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                dept.addStudent(inputStudent(sc));
                break;

            case 2:
                dept.displayStudents();
                break;

            case 3: 
                studentService.updateStudent(sc);
                break;
            
            case 4:
                System.out.print("Enter roll no to delete: ");
                int rollDel = sc.nextInt(); sc.nextLine();
                if (dept.removeStudent(rollDel)) System.out.println("Student deleted!");
                else System.out.println("Student not found!");
                break;
            
            case 5:
                dept.addFaculty(inputFaculty(sc));
                break;
            case 6 : 
                dept.displayFaculties();
                break;
            case 7 : 
                System.out.print("Enter faculty name to update: ");
                String fname = sc.nextLine();
                Faculty facUp = dept.findFaculty(fname);
                if (facUp != null) {
                    Faculty updated = inputFaculty(sc);
                    facUp.update(updated.getName(), updated.getName());
                    System.out.println("Faculty updated!");
                } else System.out.println("Faculty not found!");
                break;
            
            case 8 : 
                System.out.print("Enter faculty name to delete: ");
                String fdel = sc.nextLine();
                if (dept.removeFaculty(fdel)) System.out.println("Faculty deleted!");
                else System.out.println("Faculty not found!");
                break;
            
            default : 
                System.out.println("Invalid choice!");
        }
    
    }

    public static void facultyMenu(Scanner sc){
        System.out.println("\n--- Faculty Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Logout");
        System.out.print("Choice: ");
        int choiceF = sc.nextInt(); sc.nextLine();

        switch (choiceF) {
            case 1 -> dept.addStudent(inputStudent(sc));
            case 2 -> dept.displayStudents();
            // case 3 -> roleExit = true; 
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void studentMenu(Scanner sc){
        System.out.print("Enter your roll no: ");
        int rollCheck = sc.nextInt(); sc.nextLine();
        Student s = dept.findStudent(rollCheck);
        if (s != null) s.display();
        else System.out.println("Student not found!");
        // roleExit = true; // logout automatically
    }
    

    // --- Helper Methods ---
    private static Student inputStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String sName = sc.nextLine();
        System.out.print("Enter roll no: ");
        int roll = sc.nextInt(); sc.nextLine();
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

    private static Student inputStudent(Scanner sc, int roll) {
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

    private static Faculty inputFaculty(Scanner sc) {
        System.out.print("Enter faculty name: ");
        String fName = sc.nextLine();
        System.out.print("Enter subject: ");
        String subj = sc.nextLine();
        return new Faculty(fName, subj);
    }
}
