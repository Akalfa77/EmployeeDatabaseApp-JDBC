package service;
import db.DBConnection;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import package
//load and register
//create connection
//create statement
//execute statement
//process the result
//close
public class EmployeeService {

    public void addEmployee(Employee emp) {
        String query = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); //Calls a helper class
             PreparedStatement ps = con.prepareStatement(query)) { //create statement
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());
            ps.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> viewEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void updateEmployee(int id, double newSalary) {
        String query = "UPDATE employees SET salary = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee updated!");
            else System.out.println("Employee not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("🗑️ Employee deleted!");
            else System.out.println("Employee not found!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
