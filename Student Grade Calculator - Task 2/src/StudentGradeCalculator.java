import java.util.Scanner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Get the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer

        // Input: Take subject names and marks obtained in each subject
        String[] subjectNames = new String[numberOfSubjects];
        int[] marks = new int[numberOfSubjects];
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter subject " + (i + 1) + " name: ");
            subjectNames[i] = scanner.nextLine();
            System.out.print("Enter marks obtained in " + subjectNames[i] + " (out of 100): ");
            marks[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            //Basic input validation
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid Marks. Marks should be between 0 and 100. Exiting...");
                return;
            }
        }

        // Calculate Total Marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade Calculation
        String grade = calculateGrade(averagePercentage);

        // Display Results
        System.out.println("\nResults:");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println(subjectNames[i] + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Function to calculate the grade based on average percentage
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C+";
        } else if (averagePercentage >= 40) {
            return "C";
        } else if (averagePercentage >= 30) {
            return "D";
        } else if (averagePercentage >= 20) {
            return "E";
        } else {
            return "F";
        }
    }

