package com.crs.controller;

import com.crs.dao.CourseDAO;
import com.crs.dao.StudentDAO;
import com.crs.model.*;
import com.crs.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.util.List;

public class StudentDashboardController {
    @FXML private Label studentNameLabel;
    @FXML private Text welcomeUsernameText;
    @FXML private StackPane contentArea;

    private CourseDAO courseDAO;
    private StudentDAO studentDAO;
    private EnrollmentService enrollmentService;
    private AcademicRecordService academicRecordService;
    private AuthenticationService authenticationService;

    public StudentDashboardController() {
        courseDAO = new CourseDAO();
        studentDAO = new StudentDAO();
        enrollmentService = new EnrollmentService();
        academicRecordService = new AcademicRecordService();
        authenticationService = new AuthenticationService();
    }

//    public void setUser(User user) {
//        studentNameLabel.setText("Welcome, " + user.getUsername());
//        welcomeUsernameText.setText(user.getUsername());
//    }

    @FXML
    private void showAvailableCourses() {
        if (!authenticationService.hasPermission("VIEW_COURSES")) {
            showAlert("Error", "You don't have permission to view courses");
            return;
        }

        VBox courseView = new VBox(10);
        TextField searchField = new TextField();
        searchField.setPromptText("Search courses...");

        TableView<Course> courseTable = new TableView<>();
        TableColumn<Course, String> codeCol = new TableColumn<>("Code");
        TableColumn<Course, String> nameCol = new TableColumn<>("Name");
        TableColumn<Course, Integer> creditsCol = new TableColumn<>("Credits");

        courseTable.getColumns().addAll(codeCol, nameCol, creditsCol);
        courseTable.setItems(FXCollections.observableArrayList(courseDAO.getAllCourses()));

        Button registerBtn = new Button("Register");
        registerBtn.setOnAction(e -> registerForCourse(courseTable.getSelectionModel().getSelectedItem()));

        courseView.getChildren().addAll(searchField, courseTable, registerBtn);
        contentArea.getChildren().setAll(courseView);
    }

    private void registerForCourse(Course course) {
        if (!authenticationService.hasPermission("ENROLL_COURSE")) {
            showAlert("Error", "You don't have permission to enroll in courses");
            return;
        }

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Course Registration");

        TextField studentNameField = new TextField();
        studentNameField.setPromptText("Enter student name");
        TextField semesterField = new TextField();
        semesterField.setPromptText("Enter semester");

        VBox content = new VBox(10);
        content.getChildren().addAll(
                new Label("Student Name:"), studentNameField,
                new Label("Semester:"), semesterField
        );

        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                try {
                    Student student = new Student();
                    student.setName(studentNameField.getText());
                    studentDAO.saveStudent(student);
                    enrollmentService.enrollStudent(student, course, semesterField.getText());
                    showAlert("Success", "Successfully registered for the course!");
                } catch (Exception e) {
                    showAlert("Error", "Failed to register: " + e.getMessage());
                }
            }
            return null;
        });

        dialog.showAndWait();
    }

    @FXML
    private void calculateGPA() {
        if (!authenticationService.hasPermission("VIEW_GRADES")) {
            showAlert("Error", "You don't have permission to view grades");
            return;
        }

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Calculate GPA");

        TextField studentNameField = new TextField();
        studentNameField.setPromptText("Enter student name");
        TextField semesterField = new TextField();
        semesterField.setPromptText("Enter semester");

        VBox content = new VBox(10);
        content.getChildren().addAll(
                new Label("Student Name:"), studentNameField,
                new Label("Semester:"), semesterField
        );

        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                try {
                    Student student = new Student();
                    student.setName(studentNameField.getText());
                    double gpa = academicRecordService.calculateGPA(student, semesterField.getText());
                    showAlert("GPA Result", "Your GPA for " + semesterField.getText() + " is: " + String.format("%.2f", gpa));
                } catch (Exception e) {
                    showAlert("Error", "Failed to calculate GPA: " + e.getMessage());
                }
            }
            return null;
        });

        dialog.showAndWait();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleLogout() throws IOException {
        authenticationService.logout();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/crs/login-view.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) studentNameLabel.getScene().getWindow();
        stage.setScene(scene);
    }
}