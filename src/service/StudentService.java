package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student added: " + student.getName() + " (" + student.getMatricNumber() + ")");
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findByMatricNumber(String matricNumber) {
        for (Student student : students) {
            if (student.getMatricNumber().equalsIgnoreCase(matricNumber)) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(String matricNumber) {
        Student student = findByMatricNumber(matricNumber);
        if (student != null) {
            students.remove(student);
            System.out.println("❌ Student removed: " + student.getName());
            return true;
        }
        return false;
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println("🎓 Name: " + student.getName());
            System.out.println("   Matric: " + student.getMatricNumber());
            System.out.println("   Dept: " + student.getDepartment());
            System.out.println("   Level: " + student.getLevel());
            System.out.println("   Registered Courses:");
            student.getCourses().forEach(course ->
                    System.out.println("     • " + course.getCourseCode() + " - " + course.getCourseTitle() + " (" + course.getUnit() + " units)")
            );
            System.out.println("-----------------------------------");
        }
    }

    public List<Student> getStudentList() {
        return students;
    }
}

