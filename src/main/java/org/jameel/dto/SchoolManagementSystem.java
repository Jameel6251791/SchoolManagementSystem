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

    /**
     * Finds a department based on department ID
     * @param departmentId department ID
     */
    public Department findDepartment(String departmentId) {}

    /**
     * Finds a student based on student ID
     * @param studentId student ID
     */
    public Student findStudent(String studentId) {}

    /**
     *  Finds a teacher based on teacher ID
     * @param teacherId teacher ID
     */
    public Teacher findTeacher(String teacherId) {}

    /**
     * Finds a course based on course ID
     * @param courseId course ID
     */
    public Course findCourse(String courseId) {}

    /**
     * Adds a new department
     * @param departmentName department name
     */
    public void addDepartment(String departmentName) {}

    /**
     * Adds a new student
     * @param lName student's last name
     * @param fName student's first name
     * @param departmentId student's department ID
     */
    public void addStudent(String lName, String fName, String departmentId ) {}

    /**
     * Adds a new teacher
     * @param lName teacher's last name
     * @param fName teacher's first name
     * @param departmentId teacher's department ID
     */
    public void addTeacher(String lName, String fName, String departmentId) {}

    /**
     * Add a new course
     * @param courseName course name
     * @param credit course credit value
     * @param departmentId course's department ID
     */
    public void addCourse(String courseName, double credit, String departmentId) {}

    /**
     * Register a student to a course based on student ID and course ID
     * @param studentId student ID
     * @param courseId student ID
     */
    public void registerCourse(String studentId, String courseId) {}

    /**
     * Assigns a teacher to a course based on teacher ID and course ID
     * @param teacherId teacher ID
     * @param courseId course ID
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {}

    /**
     * prints all departments
     */
    public void printDepartments() {}

    /**
     * prints all students
     */
    public void printStudents() {}

    /**
     * prints all teachers
     */
    public void printTeacher() {}

    /**
     * prints all courses
     */
    public void printCourses() {}
}
