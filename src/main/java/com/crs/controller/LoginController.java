package com.crs.controller;

import com.crs.service.AuthenticationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private AuthenticationService authService = new AuthenticationService();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter both username and password");
            return;
        }

        try {
            if (authService.login(username, password)) {
                // Navigate to main application window based on role
                switch (authService.getCurrentUser().getRole()) {
                    case ADMIN:
                        loadAdminDashboard();
                        break;
                    case FACULTY:
                        loadFacultyDashboard();
                        break;
                    case STUDENT:
                        loadStudentDashboard();
                        break;
                }
            } else {
                errorLabel.setText("Invalid username or password");
            }
        } catch (Exception e) {
            errorLabel.setText("Login error: " + e.getMessage());
        }
    }

    @FXML
    private void showRegister() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/register.fxml")));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            errorLabel.setText("Error loading registration page");
        }
    }

    private void loadAdminDashboard() {
        // TODO: Implement admin dashboard loading
    }

    private void loadFacultyDashboard() {
        // TODO: Implement faculty dashboard loading
    }

    private void loadStudentDashboard() {
        // TODO: Implement student dashboard loading
    }
}