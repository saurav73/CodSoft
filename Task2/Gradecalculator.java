package Task2;

import java.util.Scanner;

public class Gradecalculator {

    public void runGradeCalculator() {
        Scanner scanner = new Scanner(System.in);

        // Display table header
        clearScreen();
        System.out.println("+-------------------------------------+");
        System.out.println("|         Grade Calculator             |");
        System.out.println("+-------------------------------------+");

        // Input the number of students and subjects
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();


        // Input grades for each student and subject
        String[] students = new String[numStudents];
        String[] subjects = new String[numSubjects];
        double[][] grades = new double[numStudents][numSubjects];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("+-------------------------------------------+");
            System.out.print("Enter the student name: ");
            students[i] = scanner.next();

            for (int j = 0; j < numSubjects; j++) {
                System.out.println("+-------------------------------------------+");
                System.out.print("Enter the subject name: ");
                subjects[j] = scanner.next();

                System.out.print("Enter the grade for " + students[i] + " in " + subjects[j] + ": ");
                grades[i][j] = scanner.nextDouble();
            }
        }

        // Calculate average for each student
        double[] averages = calculateAverages(grades);

        // Display the result in a table
        displayResult(students, subjects, grades, averages);

        scanner.close();
    }



    private void clearScreen() {
        // Print newline characters to "clear" the console screen
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }



    // Method to calculate averages for each student
    private double[] calculateAverages(double[][] grades) {
        double[] averages = new double[grades.length];
        // Loop through each student's grades
        for (int i = 0; i < grades.length; i++) {
            double sum = 0;
            // Loop through each grade for the current student
            for (int j = 0; j < grades[i].length; j++) {
                sum += grades[i][j];
            }
            // Calculate the average for the current student
            averages[i] = sum / grades[i].length;
        }

        return averages;
    }


    private void displayResult(String[] students, String[] subjects, double[][] grades, double[] averages) {
        clearScreen();
        System.out.println("+-------------------------+");
        System.out.printf(" %-10s | %-10s |\n", "Subject", "Grade");
        System.out.println("+-------------------------+");

        for (int i = 0; i < students.length; i++) {
            double studentTotal = 0;

            for (int j = 0; j < subjects.length; j++) {
                System.out.println("+-------------------------+");
                System.out.printf(" %-10s | %-10.2f |\n",  subjects[j], grades[i][j]);
                studentTotal += grades[i][j];
            }

            displayStudentInfo(students[i], averages[i], studentTotal);
        }
    }

    private void displayStudentInfo(String student, double average, double total) {
        System.out.println("+-------------------------------------------+");
        System.out.printf("| %-15s | %-10s | %-10.2f |\n", student, "Average", average);
        System.out.printf("| %-15s | %-10s | %-10s |\n", "", "Final Grade", calculateGrade(average));
        System.out.printf("| %-15s | %-10s | %-10.2f |\n", "", "Total Marks", total);
        System.out.println("+-------------------------------------------+");
        System.out.println("");
    }

    private String calculateGrade(double average) {
        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B+";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 50) {
            return "C+";
        } else if (average >= 40) {
            return "C";
        } else {
            return "D+";
        }
    }

    public static void main(String[] args) {
        Gradecalculator calculator = new Gradecalculator();
        calculator.runGradeCalculator();
    }
}
