package com.example.qldb;

import java.io.Serializable;

public class Department implements Serializable {
    private String name;
    private String details;

    public Department(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }
}