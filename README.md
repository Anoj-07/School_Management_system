# School Management System

This is a Spring Boot project designed to manage entities like Courses, Course Materials, Students, Teachers, and Guardians. The project uses **Spring Data JPA** for database interactions and integrates with **MySQL** as the database. It also supports unit testing with **JUnit**

---

## Features

- **Course Management**: 
  - Create, read, update, and delete courses.
  - One-to-One mapping with course materials.
  - Many-to-Many relationship with students.
  - Many-to-One relationship with teachers.

- **Student Management**: 
  - Manage student details including guardian information using the `@Embedded` annotation.

- **Teacher Management**: 
  - Associate courses with teachers.

- **Course Material Management**: 
  - Link materials to courses with mandatory one-to-one mapping.

---

## Entity Relationships

1. **Course**:
   - One-to-One with `CourseMaterial`.
   - Many-to-One with `Teacher`.
   - Many-to-Many with `Student`.

2. **CourseMaterial**:
   - One-to-One with `Course`.

3. **Student**:
   - Embedded `Guardian` details.

4. **Teacher**:
   - Manages multiple courses.

---

## Technologies Used

- **Backend**:
  - Spring Boot
  - Spring Data JPA
  - MySQL

- **Testing**:
  - JUnit


---

## Database Design

### Tables:
1. **Course**:
   - Columns: `courseId`, `title`, `credit`, `teacher_id`.

2. **CourseMaterial**:
   - Columns: `courseMaterialId`, `url`, `course_id`.

3. **Student**:
   - Columns: `studentId`, `firstName`, `lastName`, `email_address`.

4. **Teacher**:
   - Columns: `teacherId`, `firstName`, `lastName`.

5. **Guardian**:
   - Embedded in `Student`: `Name`, `Email`, `Mobile`.

6. **Student-Course Map**:
   - Junction table for Many-to-Many relationship.

---

## Prerequisites

1. **Java**: JDK 17 or later.
2. **MySQL**: Running instance with schema created.
3. **Junit**: For unit testing.

---

## Setup Instructions

1. **Clone the Repository**:
  ```bash
   git clone https://github.com/Anoj-07/School_Management_system
   cd School_Management_system
```

2.**Update Database Configuration**:
  ```
spring.datasource.url=jdbc:mysql://localhost:3306/course_management
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the Application**:
```./mvnw spring-boot:run

```
4. **Run Unit Tests**:
```
./mvnw test

```

## Future Enhancements
- Implement pagination and sorting for listing APIs.
- Add validation for inputs using Spring Boot's validation annotations.
- Add authentication and authorization using Spring Security.
