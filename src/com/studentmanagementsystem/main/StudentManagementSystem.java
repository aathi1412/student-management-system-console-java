package src.com.studentmanagementsystem.main;
import java.util.*;

import src.com.studentmanagementsystem.service.LoginSystem;
import src.com.studentmanagementsystem.service.UserService;
import src.com.studentmanagementsystem.model.Department;
import src.com.studentmanagementsystem.model.Faculty;
import src.com.studentmanagementsystem.model.Student;
import src.com.studentmanagementsystem.model.User;

public class StudentManagementSystem {
        private static UserService userService = new UserService();
        private static User currentUser = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LoginSystem loginSystem = new LoginSystem();
        

        Department dept = new Department("Computer Science");

        System.out.println("===== Student Management System =====");

        boolean programExit = false;
        while (!programExit) {
  
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    register(sc);
                    break;

                case 2:
                    login(sc);
                    break;
            
                case 3:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }

            

            boolean roleExit = false;
            while (!roleExit) {
                switch (currentUser.getRole()) {
                    case "admin" -> {
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
                        int choiceA = sc.nextInt(); sc.nextLine();

                        switch (choiceA) {
                            case 1 -> dept.addStudent(inputStudent(sc));
                            case 2 -> dept.displayStudents();
                            case 3 -> {
                                System.out.print("Enter roll no to update: ");
                                int rollUp = sc.nextInt(); sc.nextLine();
                                Student stuUp = dept.findStudent(rollUp);
                                if (stuUp != null) {
                                    Student updated = inputStudent(sc, rollUp);
                                    stuUp.update(updated.getName(), updated.getName(), 80, true, "Updated");
                                    System.out.println("Student updated!");
                                } else System.out.println("Student not found!");
                            }
                            case 4 -> {
                                System.out.print("Enter roll no to delete: ");
                                int rollDel = sc.nextInt(); sc.nextLine();
                                if (dept.removeStudent(rollDel)) System.out.println("Student deleted!");
                                else System.out.println("Student not found!");
                            }
                            case 5 -> dept.addFaculty(inputFaculty(sc));
                            case 6 -> dept.displayFaculties();
                            case 7 -> {
                                System.out.print("Enter faculty name to update: ");
                                String fname = sc.nextLine();
                                Faculty facUp = dept.findFaculty(fname);
                                if (facUp != null) {
                                    Faculty updated = inputFaculty(sc);
                                    facUp.update(updated.getName(), updated.getName());
                                    System.out.println("Faculty updated!");
                                } else System.out.println("Faculty not found!");
                            }
                            case 8 -> {
                                System.out.print("Enter faculty name to delete: ");
                                String fdel = sc.nextLine();
                                if (dept.removeFaculty(fdel)) System.out.println("Faculty deleted!");
                                else System.out.println("Faculty not found!");
                            }
                            case 9 -> roleExit = true; 
                            default -> System.out.println("Invalid choice!");
                        }
                    }

                    case "faculty" -> {
                        System.out.println("\n--- Faculty Menu ---");
                        System.out.println("1. Add Student");
                        System.out.println("2. View All Students");
                        System.out.println("3. Logout");
                        System.out.print("Choice: ");
                        int choiceF = sc.nextInt(); sc.nextLine();

                        switch (choiceF) {
                            case 1 -> dept.addStudent(inputStudent(sc));
                            case 2 -> dept.displayStudents();
                            case 3 -> roleExit = true; 
                            default -> System.out.println("Invalid choice!");
                        }
                    }

                    case "student" -> {
                        System.out.print("Enter your roll no: ");
                        int rollCheck = sc.nextInt(); sc.nextLine();
                        Student s = dept.findStudent(rollCheck);
                        if (s != null) s.display();
                        else System.out.println("Student not found!");
                        roleExit = true; // logout automatically
                    }
                }
            }
        }

        System.out.println("Thank you for using the system!");
    }

    private static void register(Scanner sc) {
        userService.register(sc);
    }

    public static void login(Scanner sc){
        try {
            currentUser = userService.login(sc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
