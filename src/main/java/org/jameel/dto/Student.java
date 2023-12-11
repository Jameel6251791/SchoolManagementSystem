package org.jameel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Student class with field variables: first name, last name, courses, courseNum, department and ID
 * as well as methods: constructor and toString
 * @author Jameel Hassan
 */
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

    /**
     * Constructor with parameters first name, last name and department.
     * Initializes first name, last name, courses, department and ID
     * @param fName first name
     * @param lName last name
     * @param department department
     */
    public Student(String fName, String lName, Department department) {
        this.fName = fName;
        this.lName = lName;
        this.courses = new Course[MAX_COURSE_NUM];
        this.id = String.format("S%03d", nextId++);
        this.department = department;
    }

    /**
     * Creates a string that contains the first name, the last name, all courses in the course array that are not null,
     * the department and the ID
     * @return a string
     */
    @Override
    public String toString() {
        String courseString = "[";
        int lastIdx = courses.length - 1;

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
