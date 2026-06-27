package src.com.studentmanagementsystem.service;

import java.util.Scanner;

import src.com.studentmanagementsystem.model.User;

public class UserService {

    private LoginSystem loginSystem = new LoginSystem();

    public User login(Scanner sc) throws Exception {
        while (true) {
            System.out.println("\n--- Select Role ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Faculty Login");
            System.out.println("3. Student Login");
            System.out.print("Enter Choice: ");

            String roleInput = sc.nextLine().trim();
            int roleChoice;
            try {
                roleChoice = Integer.parseInt(roleInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Choice");
                continue;
            }

            String role;
            switch (roleChoice) {
                case 1:
                    role = "admin";
                    break;
                case 2:
                    role = "faculty";
                    break;
                case 3:
                    role = "student";
                    break;
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }

            System.out.print("Enter username: ");
            String uname = sc.nextLine().trim();
            System.out.print("Enter password: ");
            String pass = sc.nextLine().trim();

            User loggedIn = loginSystem.login(uname, pass, role);
            if (loggedIn == null) {
                System.out.println("Invalid login! Try again.");
                continue;
            }

            System.out.println("Login successful! Role: " + loggedIn.getRole());
            return loggedIn;
        }
    }
}
