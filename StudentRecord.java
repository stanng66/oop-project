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
// Represents one student information (name, id, grades, grade calculation, pass/fail status)
public class StudentRecord {
  // Student with relevant information (name, ID, and grades)
  private String studentName;
  private String studentID;
  private double studentGrades;

  // Constructor initializes student object
  public StudentRecord(String parmStudentName, String parmStudentID, double parmStudentgrades) {
    this.studentName = parmStudentName;
    this.studentID = parmStudentID;
    this.studentGrades = parmStudentgrades;
  }

  // Decision Making - letter grade 
  public String letterGrade() { 
    double m = studentGrades;
    if (m >= 80) return "A";
    else if (m >= 70) return "B";
    else if (m >= 60) return "C";
    else if (m >= 50) return "D";
    else return "F";
  }

  // Pass/fail status base on input grades
  public String evaluateStatus() {   
    return studentGrades >= 50 ? "PASS" : "FAIL";
  }

  // ====================
  // Stduent name getter and setter 
  // ====================
  public String getStudentName () {
    return studentName;
  }

   public void setStudentName (String newName) {
    this.studentName = newName;
  }

  // ====================
  // Student ID getter and setter 
  // ====================
  public String getStudentID() {
    return studentID;
  }

  public void setStudentID (String newID) {
    this.studentID = newID;
  }

  // ====================
  // Student grade getter and setter
  // ====================
  public double getStudentGrades() {
    return studentGrades;
  }

  public void setStudentGrades(double newGrade) {
    this.studentGrades = newGrade;
  }

  // ====================
  // Display all existing students in the records
  // ====================
  public String toString() {
    return studentName + " (ID: " + studentID + ") - Marks: " + studentGrades + " Grade: " + letterGrade() + " Status: " + evaluateStatus();
  }
}
