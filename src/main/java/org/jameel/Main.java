package org.jameel;

import org.jameel.dto.SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem("Vanier");
        schoolManagementSystem.addDepartment("Math");
        schoolManagementSystem.addDepartment("English");
        schoolManagementSystem.addDepartment("French");
        schoolManagementSystem.addDepartment("History");
        schoolManagementSystem.addDepartment("Business");

        schoolManagementSystem.addTeacher("Bob", "Martin", "D001");
        schoolManagementSystem.addTeacher("Jim", "Penguin", "D002");
        schoolManagementSystem.addTeacher("Tom", "Scott", "D003");

        schoolManagementSystem.addStudent("Jameel", "Hassan", "D001");
        schoolManagementSystem.addStudent("Fish", "Stick", "D003");
        schoolManagementSystem.addStudent("Chips", "Ketchup", "D002");
        schoolManagementSystem.addStudent("Bear", "Paws", "D003");
        schoolManagementSystem.addStudent("John", "Soda", "D001");
        schoolManagementSystem.addStudent("Fin", "Soup", "D002");

        schoolManagementSystem.addCourse("Calculus", 2, "D001");
        schoolManagementSystem.addCourse("Programming", 2, "D001");
        schoolManagementSystem.addCourse("Literature", 2, "D002");
        schoolManagementSystem.addCourse("Introduction to Biology", 2, "D001");
        schoolManagementSystem.addCourse("World History", 2, "D004");
        schoolManagementSystem.addCourse("Introduction to Business", 2, "D005");
        schoolManagementSystem.addCourse("Microeconomics", 2, "D005");

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
        schoolManagementSystem.modifyCourseTeacher("T003", "C002");

        schoolManagementSystem.printStudents();
        schoolManagementSystem.printDepartments();
        schoolManagementSystem.printCourses();
        schoolManagementSystem.printTeacher();
    }
}
