package org.jameel;

import org.jameel.dto.SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem("Vanier");
        schoolManagementSystem.addDepartment("Math");
        schoolManagementSystem.addDepartment("English");
        schoolManagementSystem.addDepartment("French");
        schoolManagementSystem.addDepartment("History");

        schoolManagementSystem.addTeacher("Bob", "Martin", "D001");
        schoolManagementSystem.addTeacher("Jim", "Penguin", "D002");
        schoolManagementSystem.addTeacher("Tom", "Scott", "D001");

        schoolManagementSystem.addStudent("Jameel", "Hassan", "D001");
        schoolManagementSystem.addStudent("Jl", "Hassan", "D001");
        schoolManagementSystem.addStudent("Jameel", "Hn", "D001");
        schoolManagementSystem.addStudent("Jamel", "Has", "D001");
        schoolManagementSystem.addStudent("Jal", "Han", "D001");
        schoolManagementSystem.addStudent("Jl", "Hn", "D001");

        schoolManagementSystem.addCourse("Calculus", 2, "D001");
        schoolManagementSystem.addCourse("Cheese", 2, "D001");
        schoolManagementSystem.addCourse("Bread", 2, "D001");
        schoolManagementSystem.addCourse("Bread", 2, "D001");
        schoolManagementSystem.addCourse("Bread", 2, "D001");
        schoolManagementSystem.addCourse("Bread", 2, "D001");
        schoolManagementSystem.addCourse("Bread", 2, "D001");
        schoolManagementSystem.addCourse("Bread", 2, "D001");

        schoolManagementSystem.registerCourse("S001", "C001");
        schoolManagementSystem.registerCourse("S001", "C001");
        schoolManagementSystem.registerCourse("S001", "C010");
        schoolManagementSystem.registerCourse("S002", "C001");
        schoolManagementSystem.registerCourse("S003", "C001");
        schoolManagementSystem.registerCourse("S004", "C001");
        schoolManagementSystem.registerCourse("S005", "C001");
        schoolManagementSystem.registerCourse("S006", "C001");

        schoolManagementSystem.modifyCourseTeacher("T001", "C001");
        schoolManagementSystem.modifyCourseTeacher("T002", "C001");
        schoolManagementSystem.modifyCourseTeacher("T003", "C001");

        schoolManagementSystem.printStudents();
        schoolManagementSystem.printDepartments();
        schoolManagementSystem.printCourses();
        schoolManagementSystem.printTeacher();
    }
}
