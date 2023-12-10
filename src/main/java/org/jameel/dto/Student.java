package org.jameel.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Student {
    private static int nextId = 1;
    public static final int MAX_COURSE_NUM = 5;

    private String fName;
    private String lName;
    private Course[] courses;
    @Setter private int courseNum = 0;
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
        String courseString = "[";
        int lastIdx = MAX_COURSE_NUM - 1;

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                lastIdx = i - 1;
                break;
            }
        }

        for (int i = 0; i < courses.length; i++) {
            if (i == lastIdx) {
                courseString += courses[i].getCourseName();
            } else if (courses[i] != null) {
                courseString += courses[i].getCourseName() + ", ";
            }
        }
        courseString += "]";


        return "Student{" +
                "First Name: " + fName +
                ", Last Name: " + lName +
                ", Courses: " + courseString +
                ", Department: " + department.getDepartmentName() +
                ", ID: " + id +
                '}';
    }
}
