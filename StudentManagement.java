// ====================
// Project
// Stanley Nguyen
// Humber College
// CPAN-131-RNA
// Ronak Sheth
// August 16, 2026
// --------------------
// This program demonstrates using Java, showcasing OOP design, ArrayList data storage, input validation, and menu‑driven user interaction.
// ====================
// Handles studentRecord objects and various methods
import java.util.ArrayList;

public class StudentManagement {
  private ArrayList<StudentRecord> studentList = new ArrayList<>();

  // ====================
  // Method 1 - Add Students
  // ====================
  public void addStudent(StudentRecord newStudentList) {
    for (StudentRecord s : studentList) {
      if (s.getStudentID().equals(newStudentList.getStudentID())) {
        System.out.println("A student with this ID already exists. Please use a unique ID.");
        return;
      }
    }

    studentList.add(newStudentList);
  }

  // ====================
  // Method 2 - View all stored students
  // ====================
  public void viewStudents() {
    if (studentList.isEmpty()) {   // if no records return statement
      System.out.println("No students found.");
      return;
    }
    for (StudentRecord currentStudentList : studentList) {   // When there is existing records, print list of students
      System.out.println(currentStudentList);
    }
  }

  // ====================
  // Method 3 - Search student by id
  // ====================
  public void searchStudent(String searchStudentID) {
    for (StudentRecord searchStudentList : studentList) {
      if (searchStudentList.getStudentID().equals(searchStudentID)) {
        System.out.println("Student record has been found:");
        System.out.println(searchStudentList);
        return;
      }
    }
    System.out.println("Student not found.");
  }

  // ====================
  // Method 4 - Delete Student information
  // ====================
  public void deleteStudent(String deleteStudentID) {
    for (StudentRecord deleteStudentList : studentList) {
      if (deleteStudentList.getStudentID().equals(deleteStudentID)) {
        studentList.remove(deleteStudentList);
        System.out.println("Student record has been deleted.");
        return;
      }
    }
    System.out.println("Student not found.");
  }

  // ====================
  // Method 5 - Updating/modifying student grades
  // ====================
  public void updateMark(String studentID, double newMark) {
    for (StudentRecord updateStudentList : studentList) {
      if (updateStudentList.getStudentID().equals(studentID)) {
        updateStudentList.setStudentMark(newMark);
        System.out.println("Mark updated.");
        return;
      }
    }
    System.out.println("Student not found.");
  }

  // ====================
  // Method 6 - Calculate grade averages
  // ====================
  public double getAverage() {
    if (studentList.isEmpty()) return 0;

    double total = 0;
    for (StudentRecord s : studentList) {
      total += s.getStudentMark();
    }
    return total / studentList.size();
  }

  // ====================
  // Method 7 - Finds the highest grade in the student record
  // ====================
  public void getHighestGrade() {
    if (studentList.isEmpty()) {
      System.out.println("No students found.");
      return;
    }

    StudentRecord highestStudentGrade = studentList.get(0);

    for (StudentRecord studentRecord : studentList) {
      if (studentRecord.getStudentMark() > highestStudentGrade.getStudentMark()) {
        highestStudentGrade = studentRecord;
      }
    }

    System.out.println("Highest Mark: " + highestStudentGrade.getStudentMark());
    System.out.println("Student: " + highestStudentGrade.getStudentName() + " (ID: " + highestStudentGrade.getStudentID() + ")");
  }

  // ====================
  // Method 8 - Finds the percentage of students with a passing mark  
  // ====================
  public double calculatePassingPercentage() {
    if (studentList.isEmpty()) return 0;
    int passCount = 0;

    for (StudentRecord studentRecord : studentList) {
      if (studentRecord.getStudentMark() >= 50) {
        passCount++;
      }
    }

    double averagePercentage = (double) passCount / studentList.size() * 100;
    return averagePercentage;
  }
}