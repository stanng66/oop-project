// ====================
// Project
// Stanley Nguyen
// Humber College
// CPAN-131-RNA
// Ronak Sheth
// August 16, 2026
// --------------------
// This program demonstrates 
// ====================
// Handles menu, user inputs, and calling methods from other classes
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")   // Gets rid of yellow warning on scanner
        Scanner scanner = new Scanner(System.in);   
        SchoolDatabase curStudentRec = new SchoolDatabase();   // call the ManageStudentRec class

        while (true) {
          // Display a menu to the user
          System.out.println("\n=== Smart Campus System ===");
          System.out.println("1. Add Student");
          System.out.println("2. View all Students");
          System.out.println("3. Update Student Grades");
          System.out.println("4. Show Average Grades");
          System.out.println("5. Search Student by ID");
          System.out.println("6. Delete Student Record");
          System.out.println("7. Passing Students Percentage");
          System.out.println("8. Highest Grade");
          System.out.println("9. Exit");
          System.out.print("Choose an option: ");

          // Input scanner for user
          int choice = scanner.nextInt();
          scanner.nextLine();

          switch (choice) {   
            // Adding new student information
            case 1: 
            System.out.print("Enter name: ");
            String userName = scanner.nextLine();
            System.out.print("Enter ID: ");
            String userID = scanner.nextLine();
            System.out.print("Enter marks: ");
            double userMarks = scanner.nextDouble();

            // User grades input validation 
            if (userMarks < 0 || userMarks > 100) {
              System.out.println("Invalid marks. Grade must be between 0 and 100.");
              break;
            }

            curStudentRec.addStudent(new StudentRecord(userName, userID, userMarks));
            System.out.println("Student information added.");
            break;

            // Retrieving and displaying stored data
            case 2: curStudentRec.viewStudents();
            break;

            // modify existing student marks (updating student grade)
            case 3: 
            System.out.print("Enter ID to update: ");
            String updateID = scanner.nextLine();
            System.out.print("Enter new marks: ");
            double newMarks = scanner.nextDouble();
            curStudentRec.updateMarks(updateID, newMarks);
            break;

            // computing grade averages
            case 4: 
            System.out.println("Average marks: " + curStudentRec.getAverage());
            break;

            // Search existing stored data
            case 5: 
            System.out.println("Enter ID to Search: ");
            String searchID = scanner.nextLine();
            curStudentRec.searchStudent(searchID);
            break;

            // Delete information
            case 6: 
            System.out.println("Enter ID to Delete: ");
            String deleteID = scanner.nextLine();
            curStudentRec.deleteStudent(deleteID);
            break;

            // Computing percentage of passing students
            case 7: 
            double passPercentage = curStudentRec.getPassingPercentage();
            System.out.println("Percentage of students passing: " + passPercentage + "%");
            break;

            // Retrieve existing highest grade
            case 8:
            System.out.println("Highest Grade:");
            curStudentRec.getHighestMark();
            break;
  
            // Exit program
            case 9: 
            System.out.println("You have exited the Campus Student System. Goodbye!");
            return;

            default: System.out.println("Invalid choice.");
           }
        }
    }
}
