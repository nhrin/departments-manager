package org.example.dao;

import org.example.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDao {
    private String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.getCatalog();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM departments");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                departments.add(new Department(id, name));
            }
        } catch (SQLException e) {
            throw  new RuntimeException();
        }

        return departments;
    }

    public void update(Department department) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("UPDATE Departments SET `name` = ? WHERE id = ?");
            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Department department) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/mydb", "root", "root")) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Departments (`name`) VALUES (?)");
            statement.setString(1, department.getName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/mydb", "root", "root")) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Departments WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
