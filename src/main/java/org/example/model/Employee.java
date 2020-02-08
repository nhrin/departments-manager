package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String email;
    private int departmentId;

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Employee(String name, String email, int departmentId) {
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
    }
}