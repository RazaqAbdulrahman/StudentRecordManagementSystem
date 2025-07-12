import model.Course;
import model.Student;
import service.CourseLoaderService;
import service.GPAService;
import service.StudentService;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COURSE_FILE = "resources/courses_catalog.txt";

    public static void main(String[] args) {
        List<Course> allCourses = CourseLoaderService.loadCourses();

        if (allCourses.isEmpty()) {
            System.out.println("Failed to load courses. Please check your catalog file.");
            return;
        }

        StudentService studentService = new StudentService();
        GPAService gpaService = new GPAService();

        // Create Student
        System.out.print("Enter student full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter matric number: ");
        String matricNumber = scanner.nextLine();

        // Department selection
        Map<Integer, String> departments = new HashMap<>();
        departments.put(1, "CSC");
        departments.put(2, "ENG");
        departments.put(3, "MED");
        departments.put(4, "LAW");
        departments.put(5, "ACC");

        System.out.println("Select your department:");
        for (Map.Entry<Integer, String> entry : departments.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }

        int deptChoice = Integer.parseInt(scanner.nextLine());
        String department = departments.getOrDefault(deptChoice, "CSC");

        // Level
        System.out.print("Enter your level (e.g. 100, 200...500): ");
        int level = Integer.parseInt(scanner.nextLine());

        // Semester
        System.out.print("Enter semester (1 = First, 2 = Second): ");
        int semChoice = Integer.parseInt(scanner.nextLine());
        String semester = (semChoice == 1) ? "First" : "Second";

        Student student = new Student(name, matricNumber, department, level);
        studentService.addStudent(student);

        // Filter courses
        List<Course> availableCourses = new ArrayList<>();
        for (Course course : allCourses) {
            if (course.getDepartment().equalsIgnoreCase(department)
                    && course.getLevel() == level
                    && course.getSemester().equalsIgnoreCase(semester)) {
                availableCourses.add(course);
            }
        }

        if (availableCourses.isEmpty()) {
            System.out.println("No courses available for your selection.");
        } else {
            System.out.println("\nAvailable Courses:");
            for (int i = 0; i < availableCourses.size(); i++) {
                System.out.println((i + 1) + ". " + availableCourses.get(i));
            }

            System.out.println("\nEnter the numbers of the courses you want to register (comma-separated): ");
            String[] selections = scanner.nextLine().split(",");

            for (String selection : selections) {
                int index = Integer.parseInt(selection.trim()) - 1;
                if (index >= 0 && index < availableCourses.size()) {
                    Course selectedCourse = availableCourses.get(index);
                    student.addCourse(selectedCourse);
                }
            }
        }

        // Grade input
        System.out.println("\nEnter your grades for each course:");
        for (Course c : student.getCourses()) {
            System.out.print(c.getCourseCode() + " - " + c.getCourseTitle() + ": ");
            String grade = scanner.nextLine().trim().toUpperCase();
            c.setGrade(grade);
        }

        // GPA Calculation
        double gpa = gpaService.calculateGPA(student);
        String classification = gpaService.classifyGPA(gpa);

        System.out.println("\nStudent: " + student.getName());
        System.out.println("Matric Number: " + student.getMatricNumber());
        System.out.println("GPA: " + gpa);
        System.out.println("Classification: " + classification);
    }
}


