package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String matricNumber;
    private String department;
    private int level;
    private List<Course> courses;

    public Student(String name, String matricNumber, String department, int level) {
        this.name = name;
        this.matricNumber = matricNumber;
        this.department = department;
        this.level = level;
        this.courses = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public String getDepartment() {
        return department;
    }

    public int getLevel() {
        return level;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Optional: Add method to add a single course
    public void addCourse(Course course) {
        this.courses.add(course);
    }
}


