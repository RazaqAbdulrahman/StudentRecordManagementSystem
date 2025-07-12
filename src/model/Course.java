package model;

public class Course {
    private String courseCode;
    private String courseTitle;
    private int unit;
    private String department;
    private int level;
    private String semester; // "First" or "Second"
    private String grade; // Optional: used when grades are assigned

    public Course(String courseCode, String courseTitle, int unit, String department, int level, String semester) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.unit = unit;
        this.department = department;
        this.level = level;
        this.semester = semester;
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // No logic needed — just return semester name directly
    public String getSemesterName() {
        return semester;
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseTitle + " (" + unit + " units)";
    }
}


