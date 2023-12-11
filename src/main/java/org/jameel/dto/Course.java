package org.jameel.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Course class with field variables: course name, credit, students, studentNum, teacher, department and ID
 * as well as methods: constructor and toString
 * @author Jameel Hassan
 */
@Getter
public class Course {
    private static int nextId = 1;
    public static final int MAX_STUDENT_NUM = 5;

    private double credit;
    private String id;
    private Student[] students;
    private Department department;
    @Setter private int studentNum = 0;
    @Setter private Teacher teacher;
    private String courseName;

    /**
     * Constructor with parameters course name, credit and department.
     * Initializes course name, credit, students, teacher, department and ID
     * @param courseName course name
     * @param credit credit
     * @param department department
     */
    public Course(String courseName, double credit, Department department) {
        this.credit = credit;
        this.id = String.format("C%03d", nextId++);
        this.students = new Student[MAX_STUDENT_NUM];
        this.department = department;
        this.teacher = null;
        this.courseName = courseName;
    }

    /**
     * Creates a string that contains the course name, the credit, all students in the student array that are not null,
     * the teacher, the department and ID
     * @return a string
     */
    @Override
    public String toString() {
        String studentString = "[";
        int lastIdx = students.length - 1;

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
