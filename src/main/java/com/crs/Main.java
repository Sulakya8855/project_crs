package com.crs;

import com.crs.dao.*;
import com.crs.model.*;
import com.crs.service.AcademicRecordService;
import com.crs.service.AuthenticationService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        String username = "testuser";
        String password = "password";

        // Register the user with a hashed password
        try {
            authService.registerUser(username, password, User.Role.STUDENT);
            System.out.println("User registered successfully!");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Attempt to log in
        try {
            if (authService.login(username, password)) {
                System.out.println("Login successful");
                // Login successful
                if (authService.hasPermission("VIEW_COURSES")) {
                    System.out.println("User has permission to view courses");
                    // Navigate to courses view
                }
            } else {
                System.out.println("Login failed");
                // Show error message
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // Handle error
        }
    }
}