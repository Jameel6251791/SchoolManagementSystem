package org.jameel.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter

public class Student {
    private static int nextId = 1;
    public static final int MAX_COURSE_NUM = 5;

    private String fName;
    private String lName;
    private Course[] courses;
    public int courseNum = 0;
    private Department department;
    private String id;

    public Student(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.courses = new Course[MAX_COURSE_NUM];
        this.id = String.format("S%03d", nextId++);
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", courses=" + Arrays.toString(courses) +
                ", department=" + department +
                ", id='" + id + '\'' +
                '}';
    }
}
