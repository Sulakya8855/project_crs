# Course Registration System (CRS)

A JavaFX-based academic course registration system for students, faculty, and administrators.

## System Requirements

- Java Development Kit (JDK) 17 or higher
- Maven 3.8.x or higher
- MySQL 8.0 or higher

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

The application should now start running.

## Features

### For Students
- Search and view available courses
- Register for courses
- Calculate GPA
- View academic records

### For Faculty
- View course roster
- Manage grades
- View course schedules

### For Administrators
- Manage courses
- Manage Students

## Dependencies

- JavaFX 17.0.1
- Hibernate 6.2.0
- MySQL Connector/J 8.0.33
- Log4j 2.20.0

