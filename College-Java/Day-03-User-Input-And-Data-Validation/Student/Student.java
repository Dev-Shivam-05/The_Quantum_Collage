
import java.util.Scanner;

public class Student {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.print("Enter Student Name:");
        String stdName = scanner.nextLine();
        System.err.print("Enter Roll No:");
        int rollNo = scanner.nextInt();

        System.err.print("Enter Number of Subjects: ");
        int noOfSubject = scanner.nextInt();

        int[] marks = new int[noOfSubject];
        for (int i = 0; i < noOfSubject; i++) {
            System.err.print("Enter Marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            if (marks[i] < 0 || marks[i] > 100) {
                System.err.println("Invalid marks entered. Please enter marks between 0 and 100.");
                i--;
            }
        }

        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        int averageMarks = totalMarks / noOfSubject;
        char grade;
        if (averageMarks >= 90) {
            grade = 'A';
        } else if (averageMarks >= 80) {
            grade = 'B';
        } else if (averageMarks >= 70) {
            grade = 'C';
        } else if (averageMarks >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.err.println("Student Details:");
        System.err.println("Name: " + stdName);
        System.err.println("Roll No: " + rollNo);
        System.err.println("Marks:");
        for (int i = 0; i < noOfSubject; i++) {
            System.err.println("Subject " + (i + 1) + ": " + marks[i]);
        }
        System.err.println("Average Marks: " + averageMarks);
        System.err.println("Grade: " + grade);
        scanner.close();
    }
}
