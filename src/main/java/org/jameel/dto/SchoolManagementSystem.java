package org.jameel.dto;

public class SchoolManagementSystem {
    private static final int MAX_NUM_DEPARTMENT = 5;
    private static final int MAX_NUM_STUDENT = 200;
    private static final int MAX_NUM_TEACHER = 20;
    private static final int MAX_NUM_COURSE = 30;

    private String systemName;
    private Department[] departments;
    private Student[] students;
    private Teacher[] teachers;
    private Course[] courses;

    public SchoolManagementSystem(String systemName) {
        this.systemName = systemName;
        this.departments = new Department[MAX_NUM_DEPARTMENT];
        this.students = new Student[MAX_NUM_STUDENT];
        this.teachers = new Teacher[MAX_NUM_TEACHER];
        this.courses = new Course[MAX_NUM_COURSE];
    }

    public Department findDepartment(String departmentId) {}

    public Student findStudent(String studentId) {}

    public Teacher findTeacher(String teacherId) {}

    public Course findCourse(String courseId) {}

    public void addDepartment(String departmentName) {}

    public void addStudent(String lName, String fName, String string ) {}

    public void addTeacher(String lName, String fName, String string) {}

    public void addCourse(String courseName, double credit, String string) {}

    public void registerCourse(String studentId, String courseId) {}

    public void modifyCourseTeacher(String teacherId, String courseId) {}

    public void printDepartments() {}

    public void printStudents() {}

    public void printTeacher() {}

    public void printCourses() {}
}
