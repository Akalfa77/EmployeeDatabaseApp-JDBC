# Employee Database Management System (JDBC + MySQL)

A Java-based console application that demonstrates **CRUD operations** (Create, Read, Update, Delete) on an Employee Database using **JDBC (Java Database Connectivity)**.  
This project focuses on understanding the core workflow of JDBC and how Java interacts with relational databases like MySQL.

---

## Features

- Add new employees to the database
- View all employee records
- Update existing employee salary details
- Delete employees by ID
- Handles SQL exceptions and database connectivity gracefully

---

## Project Approach

The project follows a **layered approach**:
1. **Model Layer (`model`)** – Defines the Employee class representing the data structure.
2. **Service Layer (`service`)** – Handles business logic and database operations (CRUD).
3. **Database Layer (`db`)** – Manages the connection between Java and MySQL.
4. **Main Application (`Main.java`)** – Acts as the entry point and connects all layers.

This separation ensures clean, maintainable, and modular code.

---

## Core JDBC Steps Explained

The application is based on the **six fundamental steps of JDBC**, shown below with short explanations:

```java
// 1. Import package
import java.sql.*; 
// Imports necessary JDBC classes for database operations.

// 2. Load and register the driver
Class.forName("com.mysql.cj.jdbc.Driver");
// Loads the MySQL driver so Java can communicate with MySQL.

// 3. Create a connection
Connection con = DriverManager.getConnection(url, user, password);
// Establishes a connection to the database using credentials.

// 4. Create a statement
Statement stmt = con.createStatement();
// Prepares an SQL statement to be executed on the database.

// 5. Execute the statement
ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
// Executes SQL queries (SELECT, INSERT, UPDATE, DELETE).

// 6. Process the result
while (rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
}
// Iterates through query results and processes each row.

// 7. Close
con.close();
// Closes the connection to free resources.
```

## Expected Outcome

- Establishes a connection with the MySQL database.  
- Performs CRUD operations seamlessly.  
- Displays all records from the `employees` table.  
- Demonstrates a clean understanding of **JDBC workflow and architecture**.

---

## Conclusion

This project demonstrates a **complete end-to-end JDBC implementation**, following best practices in connection handling and modular design.  
It’s an ideal foundation for understanding **real-world Java–Database integration** and serves as a strong portfolio project for internships and job applications.
nection with the MySQL database.  
- Performs CRUD operations seamlessly.  
- Displays all records from the `employees` table.  
- Demonstrates a clean understanding of **JDBC workflow and architecture**.

---

## Conclusion

This project demonstrates a **complete end-to-end JDBC implementation**, following best practices in connection handling and modular design.  
It’s an ideal foundation for understanding **real-world Java–Database integration** and serves as a strong portfolio project for internships and job applications.

> **Note:** Please update the `config/db.properties` file with **your own MySQL username and password** before running the project.
