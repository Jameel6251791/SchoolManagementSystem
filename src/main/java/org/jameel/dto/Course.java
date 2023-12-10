package org.jameel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Course {
    private static int nextId = 1;
    public static final int MAX_STUDENT_NUM = 5;

    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    @Setter private int studentNum;
    @Setter private Teacher teacher;
    private String courseName;

    public Course(String courseName, double credit, Department department) {
        this.credit = credit;
        this.id = String.format("C%03d", nextId++);
        this.students = new Student[MAX_STUDENT_NUM];
        this.department = department;
        this.teacher = null;
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        String studentString = "[";
        int lastIdx = MAX_STUDENT_NUM - 1;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                lastIdx = i - 1;
                break;
            }
        }

        for (int i = 0; i < students.length; i++) {
            if (i == lastIdx) {
                studentString += students[i].getFName() + " " + students[i].getLName();
            } else if (students[i] != null) {
                studentString += students[i].getFName() + " " + students[i].getLName() + ", ";
            }
        }
        studentString += "]";

        String teacherString = "None";
        if (teacher != null) {
            teacherString = teacher.getFName() + " " + teacher.getLName();
        }

        return "Course{" +
                "Course Name: " + courseName +
                ", Credit: " + credit +
                ", Students: " + studentString +
                ", Teacher: " + teacherString +
                ", Department: " + department.getDepartmentName() +
                ", ID: " + id +
                '}';
    }
}
