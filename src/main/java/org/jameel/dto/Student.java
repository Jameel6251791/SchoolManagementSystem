package org.jameel.dto;

import lombok.ToString;

@ToString
public class Student {
    private static final int MAX_COURSE_NUM = 5;
    private static int nextId = 1;

    private String fName;
    private String lName;
    private Course[] courses;
    private int courseNum;
    private Department department;
    private String id;

    public Student(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.courses = new Course[MAX_COURSE_NUM];
        this.id = String.format("S%03d", nextId++);
        courseNum = courses.length;
        this.department = department;
    }
}
