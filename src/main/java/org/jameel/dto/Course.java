package org.jameel.dto;

import lombok.ToString;

@ToString
public class Course { private static int nextId = 1;
    private static final int MAX_STUDENT_NUM = 5;

    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    private int studentNum;
    private Teacher teacher;
    private String courseName;

    public Course(double credit, String courseName, Department department) {
        this.credit = credit;
        this.id = String.format("C%03d", nextId++);
        this.students = new Student[MAX_STUDENT_NUM];
        this.department = department;
        this.studentNum = studentNum;
        this.teacher = new Teacher("null", "null", department);
        this.courseName = courseName;
    }
}
