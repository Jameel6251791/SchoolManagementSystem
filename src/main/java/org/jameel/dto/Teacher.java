package org.jameel.dto;

import lombok.Getter;

/**
 * Teacher class with field variables: last name, first name, department and ID
 * as well as methods: Constructor and toString
 * @author Jameel Hassan
 */
@Getter
public class Teacher {
    private static int nextId = 1;

    private String lName;
    private String fName;
    private Department department;
    private String id;

    /**
     * Constructor with parameters first name, last name and department.
     * Initializes first name, last name, department and ID
     * @param fName first name
     * @param lName last name
     * @param department department
     */
    public Teacher(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.id = String.format("T%03d", nextId++);
    }

    /**
     * Creates a string that contains the first name, the last name, the department and the ID
     * @return a string
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "First Name: " + fName +", Last Name: " + lName +
                ", Department: " + department.getDepartmentName() +
                ", ID: " + id +
                '}';
    }
}
