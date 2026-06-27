package src.com.studentmanagementsystem.service;

import java.util.*;

import src.com.studentmanagementsystem.model.User;

public  class LoginSystem {
    private List<User> users;

    public LoginSystem() {
        users = new ArrayList<>();

        users.add(new User("admin", "admin123", "admin"));
        users.add(new User("faculty", "faculty123", "faculty"));
        users.add(new User("student", "student123", "student"));
    }

    public User login(String username, String password, String role) {
        for (User u : users) {
            if (u.getUsername().equals(username) && 
                u.getPassword().equals(password) &&
                u.getRole().equalsIgnoreCase(role)) {
                return u;
            }
        }
        return null;
    }
}