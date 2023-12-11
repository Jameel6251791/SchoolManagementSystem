package org.jameel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Teacher class with field variables: last name, first name, department, course and ID
 * as well as methods: Constructor and toString
 * @author Jameel Hassan
 */
@Getter
public class Teacher {
    private static int nextId = 1;

    private String lName;
    private String fName;
    private Department department;
    @Setter private Course course;
    private String id;

    /**
     * Constructor with parameters first name, last name and department.
     * Initializes first name, last name, department, course and ID
     * @param fName first name
     * @param lName last name
     * @param department department
     */
    public Teacher(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.course = null;
        this.id = String.format("T%03d", nextId++);
    }

    /**
     * Creates a string that contains the first name, the last name, the course, the department and the ID
     * @return a string
     */
    @Override
    public String toString() {
        String courseString = "None";
        if (course != null) {
            courseString = course.getCourseName();
        }
        return "Teacher{" +
                "First Name: " + fName +", Last Name: " + lName +
                ", Department: " + department.getDepartmentName() +
                ", Course: " + courseString +
                ", ID: " + id +
                '}';
    }
}
