package org.jameel.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

@Getter
public class Course {
    private static int nextId = 1;
    public static final int MAX_STUDENT_NUM = 5;

    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    public int studentNum;
    private Teacher teacher;
    private String courseName;

    public Course(String courseName, double credit, Department department) {
        this.credit = credit;
        this.id = String.format("C%03d", nextId++);
        this.students = new Student[MAX_STUDENT_NUM];
        this.department = department;
        this.teacher = new Teacher("null", "null", department);
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "credit=" + credit +
                ", id='" + id + '\'' +
                ", students=" + Arrays.toString(students) +
                ", department=" + department +
                ", teacher=" + teacher +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
