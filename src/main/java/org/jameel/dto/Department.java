package org.jameel.dto;

import lombok.ToString;

@ToString
public class Department {
    private static int nextId = 1;

    private String id;
    private String departmentName;

    public Department(String departmentName) {
        this.id = String.format("D%03d", nextId++);
        this.departmentName = departmentName;
    }
}
