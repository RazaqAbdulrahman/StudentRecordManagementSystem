package service;

import java.util.*;

public class DepartmentPickerService {

    private static final List<String> departments = Arrays.asList(
            "Computer Science",
            "Mechanical Engineering",
            "Business Administration",
            "Mass Communication",
            "Electrical Engineering",
            "Physics",
            "Mathematics",
            "Economics",
            "Political Science",
            "Psychology"
    );

    public static String selectDepartment(Scanner scanner) {
        System.out.println("Select your department:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i));
        }

        int choice = -1;
        while (choice < 1 || choice > departments.size()) {
            System.out.print("Enter your choice (1-" + departments.size() + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Please enter a valid number.");
                scanner.next(); // consume invalid input
            }
        }

        return departments.get(choice - 1);
    }
}

