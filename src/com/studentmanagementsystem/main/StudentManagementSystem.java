package src.com.studentmanagementsystem.main;
import java.util.*;

import src.com.studentmanagementsystem.service.UserService;
import src.com.studentmanagementsystem.menus.Menu;
import src.com.studentmanagementsystem.model.User;

public class StudentManagementSystem {
    private static UserService userService = new UserService();
    private static User currentUser = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Student Management System =====");

        while (true) {
  
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    login(sc);
                    break;
            
                case 2:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }

            
        }
    }

    public static void login(Scanner sc){
        try {
            currentUser = userService.login(sc);

            switch (currentUser.getRole()) {
                case "admin":
                    Menu.adminMenu(sc);
                    break;
                
                case "faculty":
                    Menu.facultyMenu(sc);
                    break;

                case "student":
                    Menu.studentMenu(sc);
                    break;
                    
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
    }

    
}
