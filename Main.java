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
  // ANSI Colours
  public static final String RESET = "\u001B[0m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String CYAN = "\u001B[36m";
  public static final String PURPLE = "\u001B[35m";
    
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);   
    StudentManagement curStudentRec = new StudentManagement();

    while (true) {
      // Display a menu to the user
      System.out.println(CYAN + "\n=========================================" + RESET);
      System.out.println(PURPLE + "||       Student Record Management      ||" + RESET);
      System.out.println(PURPLE + "||         Class: Geography 101         ||" + RESET);
      System.out.println(CYAN + "========================================="  + RESET);
      System.out.println("||   1. Add New Student                 ||");
      System.out.println("||   2. View Students                   ||");
      System.out.println("||   3. Search Student                  ||");
      System.out.println("||   4. Delete Student                  ||");
      System.out.println("||   5. Update Student                  ||");
      System.out.println("||   6. Average Class Grades            ||");
      System.out.println("||   7. Highest Grade                   ||");
      System.out.println("||   8. Passing Percentage              ||");
      System.out.println("||   9. About                           ||");
      System.out.println("||   10. Exit                           ||");
      System.out.println(CYAN + "-----------------------------------------" + RESET);
      System.out.print("Choose an option: ");

      // Input scanner and error handling Validation for menu choices
      int choice;
      try { 
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {   // Catches error if user enters options outside of range
        System.out.println(RED + "Invalid input. Please enter a number from 1 to 10." + RESET);
        pause(scanner);
        continue;
      } 

      switch (choice) {   
        // Add new student information
        case 1: 
          System.out.print(YELLOW + "Enter name:" + RESET);
          String userName = scanner.nextLine();
          System.out.print(YELLOW + "Enter ID:" + RESET);
          String userID = scanner.nextLine();
          System.out.print(YELLOW + "Enter grade:" + RESET);
          double userGrades = getValidGrade(scanner);

          curStudentRec.addStudent(new StudentRecord(userName, userID, userGrades));
          System.out.println(GREEN + "Student information added." + RESET);
          pause(scanner);
          break;

        // Retrieving and displaying stored data
        case 2: curStudentRec.viewStudents();
          pause(scanner);
          break;

        // Search student data by ID
        case 3: 
          System.out.println(YELLOW + "Enter ID to Search:" + RESET);
          String searchID = scanner.nextLine();
          curStudentRec.searchStudent(searchID);
          pause(scanner);
          break;

        // Delete information
        case 4: 
          System.out.println(YELLOW + "Enter ID to Delete:" + RESET);
          String deleteID = scanner.nextLine();
          curStudentRec.deleteStudent(deleteID);
          pause(scanner);
          break;

        // Updating student grade
        case 5: 
          System.out.print(YELLOW + "Enter ID to update: " + RESET);
          String updateID = scanner.nextLine();
          System.out.print(YELLOW + "Enter new grade: " + RESET);
          double newGrades = getValidGrade(scanner);
          curStudentRec.updateGrade(updateID, newGrades);
          pause(scanner);
          break;

        // computing class averages
        case 6: 
          System.out.println("Average grades: " + curStudentRec.getAverage());
          pause(scanner);
          break;

        // Retrieve existing highest grade
        case 7:
          System.out.println("Highest grade in class");
          curStudentRec.getHighestGrade();
          pause(scanner);
          break;

        // Compute percentage of students with passing grade
        case 8:
          double passingStudents = curStudentRec.calculatePassingPercentage();
          System.out.println("Percentage of students passing: " + passingStudents + "%");
          pause(scanner);
          break;

        // Basic about page for the program
        case 9: 
          System.out.println("This system manages student academic records using OOP principles.");
          System.out.println("Developed by: Stanley Nguyen");
          pause(scanner);
          break;
  
        // Exit program
        case 10: 
          System.out.println(BLUE + "You have exited the Campus Student System. Goodbye!" + RESET);
          return;

        default: System.out.println(RED + "Invalid choice." + RESET);
      }
    }
  }

  // Press enter to return to the menu
  private static void pause(Scanner scanner) {
    System.out.print(YELLOW + "\nPress Enter to return to the menu..." + RESET);
    scanner.nextLine();
  }

  // Input validation for cases 1 and 5 grades
  public static double getValidGrade(Scanner scanner) {
    double grade;
    while (true) {
      try {
        grade = Double.parseDouble(scanner.nextLine());

        if (grade < 0 || grade > 100) {
          System.out.println(RED + "Invalid grades. Grade must be between 0 and 100." + RESET);
          continue;
        }

        return grade;

      } catch (NumberFormatException e) {
        System.out.println(RED + "Invalid grade. Please enter a number between 0 and 100." + RESET);
      }
      System.out.print(YELLOW + "Enter a valid grade:" + RESET);
    }
  }
}
