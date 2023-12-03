package org.jameel.dto;

import java.util.Scanner;

public class SchoolManagementSystem {
    Scanner console = new Scanner(System.in);
    private static final int MAX_NUM_DEPARTMENT = 5;
    private static final int MAX_NUM_STUDENT = 200;
    private static final int MAX_NUM_TEACHER = 20;
    private static final int MAX_NUM_COURSE = 30;

    private String systemName;
    private Department[] departments;
    private Student[] students;
    private Teacher[] teachers;
    private Course[] courses;
    private int departmentCounter = 0;
    private int studentCounter = 0;
    private int teacherCounter = 0;
    private int courseCounter = 0;

    public SchoolManagementSystem(String systemName) {
        this.systemName = systemName;
        this.departments = new Department[MAX_NUM_DEPARTMENT];
        this.students = new Student[MAX_NUM_STUDENT];
        this.teachers = new Teacher[MAX_NUM_TEACHER];
        this.courses = new Course[MAX_NUM_COURSE];
    }

    /**
     * Finds a department based on department ID
     *
     * @param departmentId department ID
     */
    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department.getId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Finds a student based on student ID
     *
     * @param studentId student ID
     */
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Finds a teacher based on teacher ID
     *
     * @param teacherId teacher ID
     */
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Finds a course based on course ID
     *
     * @param courseId course ID
     */
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Adds a new department
     *
     * @param departmentName department name
     */
    public void addDepartment(String departmentName) {
        if (departmentCounter < MAX_NUM_DEPARTMENT) {
            for (int i = 0; i < departments.length; i++) {
                if (departments[i] == null) {
                    departments[i] = new Department(departmentName);
                    departmentCounter++;
                    break;
                }
            }
        } else {
            System.out.println("Max number of departments added");
        }
    }

    /**
     * Adds a new student
     *
     * @param lName        student's last name
     * @param fName        student's first name
     * @param departmentId student's department ID
     */
    public void addStudent(String lName, String fName, String departmentId) {
        if (studentCounter < MAX_NUM_STUDENT) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = new Student(lName, fName, findDepartment(departmentId));
                    studentCounter++;
                    break;
                }
            }
        } else {
            System.out.println("Max number of students added");
        }
    }

    /**
     * Adds a new teacher
     *
     * @param lName        teacher's last name
     * @param fName        teacher's first name
     * @param departmentId teacher's department ID
     */
    public void addTeacher(String lName, String fName, String departmentId) {
        if (teacherCounter < MAX_NUM_TEACHER) {
            for (int i = 0; i < teachers.length; i++) {
                if (teachers[i] == null) {
                    teachers[i] = new Teacher(lName, fName, findDepartment(departmentId));
                    teacherCounter++;
                    break;
                }
            }
        } else {
            System.out.println("Max number of teachers added");
        }
    }

    /**
     * Add a new course
     *
     * @param courseName   course name
     * @param credit       course credit value
     * @param departmentId course's department ID
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        if (courseCounter < MAX_NUM_COURSE) {
            for (int i = 0; i < courses.length ; i++) {
                if (courses[i] == null) {
                    courses[i] = new Course(courseName, credit, findDepartment(departmentId));
                }
            }
        } else {
            System.out.println("Max number of courses added");
        }
    }

    /**
     * Register a student to a course based on student ID and course ID
     *
     * @param studentId student ID
     * @param courseId  student ID
     */
    public void registerCourse(String studentId, String courseId) {
        Course course = findCourse(courseId);
        Student student = findStudent(studentId);

        for (int i = 0; i < student.getCourses().length; i++) {
            if (student.getCourses()[i] == null) {
                student.getCourses()[i] = course;
                break;
            }
        }

    }

    /**
     * Assigns a teacher to a course based on teacher ID and course ID
     *
     * @param teacherId teacher ID
     * @param courseId  course ID
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
    }

    /**
     * prints all departments
     */
    public void printDepartments() {
    }

    /**
     * prints all students
     */
    public void printStudents() {
    }

    /**
     * prints all teachers
     */
    public void printTeacher() {
    }

    /**
     * prints all courses
     */
    public void printCourses() {
    }
}
