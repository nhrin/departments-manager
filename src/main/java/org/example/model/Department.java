package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Department {
    private int id;
    private String name;

    public Department(String name) {
        this.name = name;
    }
}