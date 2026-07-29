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
    StudentManagement curStudentRec = new StudentManagement();

    while (true) {
      // Display a menu to the user
      System.out.println("\n====================================");
      System.out.println("        Student Record System        ");
      System.out.println("====================================");
      System.out.println("1. Add Student information");
      System.out.println("2. View all Students");
      System.out.println("3. Search Student by ID");
      System.out.println("4. Delete Student Record");
      System.out.println("5. Update Student Grades");
      System.out.println("6. Show Average Grades");
      System.out.println("7. Highest Grade");
      System.out.println("8. About this system");
      System.out.println("9. Exit");
      System.out.println("------------------------------------");
      System.out.print("Choose an option: ");

      // Input scanner for user
      /* int choice = scanner.nextInt();
      scanner.nextLine(); */

      // Input scanner and error handling Validation for menu choices
      int choice;
      try { 
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {   // Catches error if user enters options outside of range
        System.out.println("Invalid input. Please enter a number from 1 to 8.");
        continue;
      } 

      switch (choice) {   
        // Add new student information
        case 1: 
        System.out.print("Enter name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter marks: ");
        double userGrades = scanner.nextDouble();

        // User grades input validation 
        if (userGrades < 0 || userGrades > 100) {
          System.out.println("Invalid marks. Grade must be between 0 and 100.");
          break;
        }

        curStudentRec.addStudent(new StudentRecord(userName, userID, userGrades));
        System.out.println("Student information added.");
        break;

        // Retrieving and displaying stored data
        case 2: curStudentRec.viewStudents();
        break;

        // Search student data by ID
        case 3: 
        System.out.println("Enter ID to Search: ");
        String searchID = scanner.nextLine();
        curStudentRec.searchStudent(searchID);
        break;

        // Delete information
        case 4: 
        System.out.println("Enter ID to Delete: ");
        String deleteID = scanner.nextLine();
        curStudentRec.deleteStudent(deleteID);
        break;

        // Updating student grade
        case 5: 
        System.out.print("Enter ID to update: ");
        String updateID = scanner.nextLine();
        System.out.print("Enter new marks: ");
        double newGrades = scanner.nextDouble();
        curStudentRec.updateMarks(updateID, newGrades);
        break;

        // computing grade averages
        case 6: 
        System.out.println("Average marks: " + curStudentRec.getAverage());
        break;

        // Retrieve existing highest grade
        case 7:
        System.out.println("Highest Grade:");
        curStudentRec.getHighestMark();
        break;

        // Basic about the program
        case 8: 
        System.out.println("This system manages student academic records using OOP principles.");
        System.out.println("Developed by: Stanley Nguyen");
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
