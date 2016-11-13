package com.geekhub;

public class Task {
    private String name;
    private String category;

    Task(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
    // constructor and getters
}