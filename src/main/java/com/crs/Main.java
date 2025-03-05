package com.crs;

import com.crs.dao.StudentDAO;
import com.crs.model.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John Doe1");
        student.setDob("2000-05-21");
        student.setProgram("Computer Science");
        student.setYear(3);
        student.setContactInfo("johndoe@gmail.com");

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.saveStudent(student);

        System.out.println("Student saved successfully!");
    }
}
