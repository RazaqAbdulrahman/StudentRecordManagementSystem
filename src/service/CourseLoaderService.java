package service;

import model.Course;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseLoaderService {
    public static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            InputStream inputStream = CourseLoaderService.class.getClassLoader().getResourceAsStream("courses_catalog.txt");
            if (inputStream == null) {
                System.err.println("Course catalog not found in resources.");
                return courses;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    String department = parts[0];
                    int level = Integer.parseInt(parts[1]);
                    String semester = parts[2];  // "First" or "Second"
                    String courseCode = parts[3];
                    String courseTitle = parts[4];
                    int unit = Integer.parseInt(parts[5]);

                    Course course = new Course(courseCode, courseTitle, unit, department, level, semester);
                    courses.add(course);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
}


