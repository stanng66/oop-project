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
// Handles studentRecord objects and various methods

import java.util.ArrayList;

public class SchoolDatabase {
    private ArrayList<StudentRecord> studentList = new ArrayList<>();

  // Store new students information
  public void addStudent(StudentRecord newStudentList) {
    studentList.add(newStudentList);
  }

  // View all stored students
  public void viewStudents() {
    if (studentList.isEmpty()) {   // if no records return statement
      System.out.println("No students found.");
      return;
    }
    for (StudentRecord currentStudentList : studentList) {   // When there is existing records, print list of students
      System.out.println(currentStudentList);
    }
  }

  // Allow updating/modifying student marks
  public void updateMarks(String studentID, double newMarks) {
    for (StudentRecord updateStudentList : studentList) {
      if (updateStudentList.getStudentID().equals(studentID)) {
        updateStudentList.setStudentMarks(newMarks);
        System.out.println("Marks updated.");
        return;
      }
    }
    System.out.println("Student not found.");
  }

  // Performing basic computions - Averages
  public double getAverage() {
    if (studentList.isEmpty()) return 0;

    double total = 0;
    for (StudentRecord s : studentList) {
      total += s.getStudentMarks();
    }
    return total / studentList.size();
  }

  // Search student by id
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

  // Delete Student information
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

  // Basic computing, calculates average of all students in the record with passing grades
  public double getPassingPercentage() {
    if (studentList.isEmpty()) return 0;
    int passCount = 0;

    for (StudentRecord studentRecord : studentList) {
      if (studentRecord.getStudentMarks() >=50) {
        passCount++;
      }
    }

    double averagePercentage = (double) passCount / studentList.size() * 100;
    return averagePercentage;
  }

  // Basic computing, finds the highest grade in the student record
  public void getHighestMark() {
    if (studentList.isEmpty()) {
      System.out.println("No students found.");
      return;
    }

    StudentRecord highestStudentGrade = studentList.get(0);

    for (StudentRecord studentRecord : studentList) {
      if (studentRecord.getStudentMarks() > highestStudentGrade.getStudentMarks()) {
        highestStudentGrade = studentRecord;
      }
    }

    System.out.println("Highest Grade: " + highestStudentGrade.getStudentMarks());
    System.out.println("Student: " + highestStudentGrade.getStudentName() + " (ID: " + highestStudentGrade.getStudentID() + ")");
  }
}
