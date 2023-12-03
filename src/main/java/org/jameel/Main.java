package org.jameel;

import org.jameel.dto.SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem("Vanier");
        schoolManagementSystem.addDepartment("Math");
        schoolManagementSystem.addStudent("Jameel", "Hassan", "D001");
        schoolManagementSystem.addCourse("Calculus", 2, "D001");
        schoolManagementSystem.registerCourse("S001", "C001");

        System.out.println(schoolManagementSystem.findStudent("S001"));


    }
}
