import java.util.Scanner;

public class StudentGradeCalculator{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STUDENT GRADE CALCULATOR =====");

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();
        sc.nextLine();

        String[] subjectNames = new String[subjects];
        int[] marks = new int[subjects];

        int totalMarks = 0;
        int highest = 0;
        int lowest = 100;
        boolean isFail = false;

        for (int i = 0; i < subjects; i++) {

            System.out.print("\nEnter Subject " + (i + 1) + " Name: ");
            subjectNames[i] = sc.nextLine();

            System.out.print("Enter marks for " + subjectNames[i] + " (0-100): ");
            marks[i] = sc.nextInt();
            sc.nextLine();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Marks must be between 0 and 100.");
                System.out.print("Enter marks again for " + subjectNames[i] + ": ");
                marks[i] = sc.nextInt();
                sc.nextLine();
            }

            totalMarks += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
            }

            if (marks[i] < 35) {
                isFail = true;
            }
        }

        double percentage = (double) totalMarks / subjects;

        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        String result;

        if (isFail) {
            result = "FAIL";
            grade = "F";
        } else {
            result = "PASS";
        }

        System.out.println("\n\n========== STUDENT REPORT ==========");
        System.out.println("Student Name : " + studentName);
        System.out.println("Roll Number  : " + rollNumber);
        System.out.println("------------------------------------");

        for (int i = 0; i < subjects; i++) {
            System.out.println(subjectNames[i] + " : " + marks[i]);
        }

        System.out.println("------------------------------------");
        System.out.println("Total Marks  : " + totalMarks + " / " + (subjects * 100));
        System.out.printf("Percentage   : %.2f%%\n", percentage);
        System.out.println("Grade        : " + grade);
        System.out.println("Result       : " + result);
        System.out.println("Highest Mark : " + highest);
        System.out.println("Lowest Mark  : " + lowest);
        System.out.println("====================================");

        if (result.equals("PASS")) {
            System.out.println("Congratulations! You passed successfully.");
        } else {
            System.out.println(" You failed because one or more subjects are below 35.");
        }

        sc.close();
    }
}
