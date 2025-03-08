package com.crs;

import com.crs.model.User;
import com.crs.service.AuthenticationService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

        /*AuthenticationService authService = new AuthenticationService();
        String username = "testuser1";
        String password = "password1";

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
        }*/
    }
}