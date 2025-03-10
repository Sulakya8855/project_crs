# Course Registration System (CRS)

A JavaFX-based academic course registration system for students, faculty, and administrators.

## System Requirements

- Java Development Kit (JDK) 17 or higher
- Maven 3.8.x or higher
- MySQL 8.0 or higher
- IntelliJ IDEA Professional

## Setup Instructions

### 1. Database Setup

```sql
CREATE DATABASE crs_db;
USE crs_db;
```

### 2. Configure Application

1. Open `src/main/resources/hibernate.cfg.xml`:
```properties
db.url=jdbc:mysql://localhost:3306/crs_db
db.username=your_username
db.password=your_password
```

### 3. Build & Run

1. Open IntelliJ IDEA.
2. Click on `File` -> `Open` and select the root directory of the project.
3. Wait for IntelliJ IDEA to index the project and download dependencies.
4. Open the `src/main/java/com/crs/Main.java` file (or the main class file of your application).
5. Right-click on the file and select `Run 'Main.main()'`.
6. Run `db_dump.sql` inside your database to populate the database with sample data.
7. If you want to use docker use the docker-compose file to start the database.

The application should now start running.

## Features

### For Students
- Search and view available courses
- View My enrollments
- Calculate GPA
- View Transcript

### For Faculty
- View course by department
- View course enrollments
- Manage Grades

### For Administrators
- **Manage Courses**: Create, update, delete, and retrieve courses.
- **Manage Students**: Add, update, delete, and retrieve student information.
- **Manage Academic Records**
- **Manage Enrollments**


