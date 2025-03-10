USE crs_db;

-- Insert Sample Data into Student Table
INSERT INTO students (studentId, contactInfo, dob, name, program, year) VALUES
(1, 'johndoe@gmail.com', '2000-05-23', 'John Doe', 'Computer Science', 3),
(2, 'janedoe@gmail.com', '2001-07-15', 'Jane Doe', 'Information Technology', 2),
(3, 'alice@gmail.com', '1999-12-10', 'Alice Smith', 'Software Engineering', 4),
(4, 'bob@gmail.com', '2002-03-25', 'Bob Johnson', 'Computer Science', 1),
(5, 'charlie@gmail.com', '2000-09-05', 'Charlie Brown', 'Data Science', 3),
(6, 'eva@gmail.com', '2001-04-18', 'Eva Green', 'Cyber Security', 2),
(7, 'daniel@gmail.com', '2000-06-30', 'Daniel White', 'Artificial Intelligence', 3),
(8, 'olivia@gmail.com', '1999-08-22', 'Olivia Taylor', 'Machine Learning', 4),
(9, 'michael@gmail.com', '2002-11-19', 'Michael Clark', 'Computer Science', 1),
(10, 'sophia@gmail.com', '2001-01-08', 'Sophia Lewis', 'Data Science', 2),
(11, 'lucas@gmail.com', '2000-10-11', 'Lucas Walker', 'Software Engineering', 3),
(12, 'emma@gmail.com', '2002-05-27', 'Emma Hall', 'Information Technology', 1),
(13, 'benjamin@gmail.com', '2001-07-09', 'Benjamin Allen', 'Cyber Security', 2),
(14, 'lily@gmail.com', '1999-04-16', 'Lily Adams', 'Artificial Intelligence', 4),
(15, 'samuel@gmail.com', '2000-08-14', 'Samuel Scott', 'Machine Learning', 3),
(16, 'harper@gmail.com', '2002-03-02', 'Harper Baker', 'Computer Science', 1),
(17, 'jackson@gmail.com', '2001-12-12', 'Jackson King', 'Software Engineering', 2),
(18, 'amelia@gmail.com', '1999-06-21', 'Amelia Wright', 'Cyber Security', 4),
(19, 'henry@gmail.com', '2000-02-28', 'Henry Carter', 'Data Science', 3),
(20, 'grace@gmail.com', '2002-09-30', 'Grace Turner', 'Artificial Intelligence', 1);

-- Insert Sample Data into Course Table
INSERT INTO courses (courseId, creditHours, department, maxCapacity, title) VALUES
(1, 3, 'Computer Science', 30, 'Data Structures'),
(2, 4, 'Information Technology', 25, 'Database Management'),
(3, 3, 'Software Engineering', 40, 'Software Design Patterns'),
(4, 3, 'Data Science', 35, 'Machine Learning Basics'),
(5, 4, 'Cyber Security', 20, 'Network Security'),
(6, 3, 'Artificial Intelligence', 30, 'Deep Learning'),
(7, 4, 'Machine Learning', 30, 'Natural Language Processing'),
(8, 3, 'Computer Science', 40, 'Algorithms');

-- Insert Sample Data into Enrollment Table
INSERT INTO enrollments (id, enrollmentDate, semester, status, courseId, studentId) VALUES
(1, '2025-03-08', 'Fall2023', 'ENROLLED', 1, 1),
(2, '2025-03-08', 'Fall2023', 'DROPPED', 2, 2),
(3, '2025-03-08', 'Fall2023', 'WAITLISTED', 3, 3),
(4, '2025-03-08', 'Fall2023', 'ENROLLED', 4, 4),
(5, '2025-03-08', 'Fall2023', 'ENROLLED', 5, 5),
(6, '2025-03-08', 'Fall2023', 'DROPPED', 6, 6),
(7, '2025-03-08', 'Fall2023', 'WAITLISTED', 7, 7),
(8, '2025-03-08', 'Fall2023', 'ENROLLED', 8, 8),
(9, '2025-03-08', 'Fall2023', 'ENROLLED', 1, 9),
(10, '2025-03-08', 'Fall2023', 'ENROLLED', 2, 10),
(11, '2025-03-08', 'Fall2023', 'WAITLISTED', 3, 11),
(12, '2025-03-08', 'Fall2023', 'DROPPED', 4, 12),
(13, '2025-03-08', 'Fall2023', 'ENROLLED', 5, 13),
(14, '2025-03-08', 'Fall2023', 'ENROLLED', 6, 14),
(15, '2025-03-08', 'Fall2023', 'ENROLLED', 7, 15),
(16, '2025-03-08', 'Fall2023', 'DROPPED', 8, 16),
(17, '2025-03-08', 'Fall2023', 'ENROLLED', 1, 17),
(18, '2025-03-08', 'Fall2023', 'WAITLISTED', 2, 18),
(19, '2025-03-08', 'Fall2023', 'ENROLLED', 3, 19),
(20, '2025-03-08', 'Fall2023', 'DROPPED', 4, 20);

-- Insert Sample Data into AcademicRecord Table
INSERT INTO academic_records (id, completionDate, grade, remarks, status, enrollmentId) VALUES
(1, '2025-06-08', 'A', 'Excellent', 'COMPLETED', 1),
(2, '2025-06-08', 'B+', 'Good', 'COMPLETED', 4),
(3, '2025-06-08', 'A-', 'Very Good', 'COMPLETED', 5),
(4, '2025-06-08', 'C+', 'Satisfactory', 'COMPLETED', 8),
(5, '2025-06-08', 'B', 'Good', 'COMPLETED', 9),
(6, '2025-06-08', 'A', 'Excellent', 'COMPLETED', 10),
(7, '2025-06-08', 'B-', 'Above Average', 'COMPLETED', 13),
(8, '2025-06-08', 'A', 'Outstanding', 'COMPLETED', 14),
(9, '2025-06-08', 'C', 'Average', 'COMPLETED', 15),
(10, '2025-06-08', 'B+', 'Good', 'COMPLETED', 17),
(11, '2025-06-08', 'B-', 'Above Average', 'COMPLETED', 19),
(12, '2025-06-08', 'A', 'Excellent', 'COMPLETED', 3),
(13, '2025-06-08', 'C+', 'Satisfactory', 'COMPLETED', 6),
(14, '2025-06-08', 'A-', 'Very Good', 'COMPLETED', 7),
(15, '2025-06-08', 'B+', 'Good', 'COMPLETED', 11),
(16, '2025-06-08', 'A', 'Excellent', 'COMPLETED', 12),
(17, '2025-06-08', 'B-', 'Above Average', 'COMPLETED', 16),
(18, '2025-06-08', 'C', 'Average', 'COMPLETED', 18),
(19, '2025-06-08', 'A', 'Outstanding', 'COMPLETED', 2),
(20, '2025-06-08', 'B', 'Good', 'COMPLETED', 20);
