package com.crs;

import com.crs.dao.AcademicRecordDAO;
import com.crs.dao.StudentDAO;
import com.crs.dao.CourseDAO;
import com.crs.dao.EnrollmentDAO;
import com.crs.model.AcademicRecord;
import com.crs.model.Student;
import com.crs.model.Course;
import com.crs.model.Enrollment;
import com.crs.service.AcademicRecordService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Initialize DAOs
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
        AcademicRecordService academicService = new AcademicRecordService();

        Student student = new Student();
        student.setName("John Doe");
        student.setDob("2000-05-23");
        student.setProgram("Computer Science");
        student.setYear(3);
        student.setContactInfo("johndoe@gmail.com");
        studentDAO.saveStudent(student);
        System.out.println("Student saved successfully!");

        Course course = new Course();
        course.setTitle("Data Structures");
        course.setCreditHours(3);
        course.setDepartment("Computer Science");
        course.setMaxCapacity(30);
        courseDAO.saveCourse(course);
        System.out.println("Course saved successfully!");

        // Enroll student in a course
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());
        enrollment.setStatus(Enrollment.EnrollmentStatus.ENROLLED);
        enrollment.setSemester("Fall2023");

        // Create and set academic record
        AcademicRecord record = new AcademicRecord();
        record.setEnrollment(enrollment);
        record.setGrade("A");
        record.setCompletionDate(LocalDateTime.now());
        record.setRemarks("Excellent performance");
        record.setStatus(AcademicRecord.CourseStatus.COMPLETED);

        // Add academic record to enrollment
        List<AcademicRecord> academicRecords = new ArrayList<>();
        academicRecords.add(record);
        enrollment.setAcademicRecords(academicRecords);

        // Save the enrollment (which will also save the academic record due to cascade)
        enrollmentDAO.saveEnrollment(enrollment);

        // Get transcript
        List<AcademicRecord> transcript = academicService.getStudentTranscript(student);
        System.out.println("Transcript: " + transcript.size());

        // Calculate GPA
        double semesterGPA = academicService.calculateGPA(student, "Fall2023");
        System.out.println("GPA: " + semesterGPA);
    }
}