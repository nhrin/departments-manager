package org.example.dao;

import org.example.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    public List<Employee> findAll(int departmentId) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/mydb", "root", "root")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Employees WHERE department_id = " + departmentId);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                employees.add(new Employee(id, name, email, departmentId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/mydb", "root", "root")) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Employees WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Employee employee) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/mydb", "root", "root")) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Employees (`name`, email, department_id) VALUES (?,?,?)");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setInt(3, employee.getDepartmentId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Employee employee) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/mydb", "root", "root")) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Employees SET `name` = ?, email = ? WHERE id = ?");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setInt(3, employee.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
