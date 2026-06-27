package src.com.studentmanagementsystem.main;

import java.util.Scanner;

import src.com.studentmanagementsystem.model.Department;
import src.com.studentmanagementsystem.model.User;
import src.com.studentmanagementsystem.menus.Menu;
import src.com.studentmanagementsystem.service.StudentService;
import src.com.studentmanagementsystem.service.UserService;



public class StudentManagementSystem {
    private static Department department = new Department("Computer Science");
    private static StudentService studentService = new StudentService(department);
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Student Management System =====");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choice: ");

            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Please enter a choice.");
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    login(sc);
                    break;
                case 2:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    public static void login(Scanner sc) {
        try {
            User currentUser = userService.login(sc);

            switch (currentUser.getRole().toLowerCase()) {
                case "admin":
                    Menu.adminMenu(sc, studentService);
                    break;
                case "faculty":
                    Menu.facultyMenu(sc, department);
                    break;
                case "student":
                    Menu.studentMenu(sc, department);
                    break;
                default:
                    System.out.println("Unknown role: " + currentUser.getRole());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
