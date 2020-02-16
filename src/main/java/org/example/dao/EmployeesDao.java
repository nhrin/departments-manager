package org.example.dao;

import org.example.model.Employee;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {

    private String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    public List<Employee> findAll(int departmentId) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Employees WHERE department_id = " + departmentId);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String birthday = String.valueOf(rs.getDate(3));
                String email = rs.getString(4);
                employees.add(new Employee(id, name, email, departmentId, birthday));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }

    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Employees WHERE id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Employees (`name`, email, department_id, birthday) VALUES (?,?,?,?)");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setInt(3, employee.getDepartmentId());
            statement.setDate(4, java.sql.Date.valueOf(employee.getBirthday()));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Employee employee) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Employees SET `name` = ?, email = ?, birthday = ? WHERE id = ?");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setDate(3, java.sql.Date.valueOf(employee.getBirthday()));
            statement.setInt(4, employee.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
