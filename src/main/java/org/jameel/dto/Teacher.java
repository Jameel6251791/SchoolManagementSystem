package org.jameel.dto;

public class Teacher {
    private static int nextId = 1;

    private String lName;
    private String fName;
    private Department department;
    private String id;

    public Teacher(String lName, String fName, Department department) {
        this.lName = lName;
        this.fName = fName;
        this.department = department;
        this.id = String.format("T%03d", nextId++);
    }

    @Override
    public String toString() {
        return "Teacher{" + "name='" + fName + " " + lName + '\'' +
                ", lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", department=" + department +
                ", id='" + id + '\'' +
                '}';
    }
}
