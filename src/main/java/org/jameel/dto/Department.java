package org.jameel.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * Department class with field variables: department name and ID as well as methods: constructor and toString
 * @author Jameel Hassan
 */
@Getter
@ToString
public class Department {
    private static int nextId = 1;

    private String departmentName;
    private String id;

    /**
     * Constructor with parameter department name. Initializes department name and ID
     * @param departmentName department name
     */
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.id = String.format("D%03d", nextId++);
    }
}
