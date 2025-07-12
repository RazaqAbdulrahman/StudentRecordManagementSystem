package service;

import model.Course;
import model.Student;

import java.util.List;

public class GPAService {

    private int getGradePoint(String grade) {
        switch (grade.toUpperCase()) {
            case "A": return 5;
            case "B": return 4;
            case "C": return 3;
            case "D": return 2;
            case "F": return 0;
            default: return -1;
        }
    }

    public double calculateGPA(Student student) {
        List<Course> courses = student.getCourses();

        int totalPoints = 0;
        int totalUnits = 0;

        for (Course course : courses) {
            String grade = course.getGrade();
            if (grade == null) continue; // skip ungraded courses

            int unit = course.getUnit();
            int point = getGradePoint(grade);

            if (point >= 0) {
                totalPoints += point * unit;
                totalUnits += unit;
            }
        }

        if (totalUnits == 0) return 0.0;

        return (double) totalPoints / totalUnits;
    }

    public String classifyGPA(double gpa) {
        if (gpa >= 4.5) return "First Class";
        else if (gpa >= 3.5) return "Second Class Upper";
        else if (gpa >= 2.5) return "Second Class Lower";
        else if (gpa >= 1.5) return "Third Class";
        else return "Advised To Withdraw";
    }
}


