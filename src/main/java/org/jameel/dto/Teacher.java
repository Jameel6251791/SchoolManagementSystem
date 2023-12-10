package org.jameel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Teacher {
    private static int nextId = 1;

    private String lName;
    private String fName;
    private Department department;
    @Setter private Course course;
    private String id;


    public Teacher(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.department = department;
        this.course = null;
        this.id = String.format("T%03d", nextId++);
    }

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
