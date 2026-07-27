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
    // Student with relevant information (such as name, ID, and marks)
  private String studentName;
  private String studentID;
  private double studentMarks;

  // Object-Based Design - constructor initializes student object
  public StudentRecord(String parmStudentName, String parmStudentID, double parmStudentMarks) {
    this.studentName = parmStudentName;
    this.studentID = parmStudentID;
    this.studentMarks = parmStudentMarks;
  }

  // Decision Making - letter grade 
  public String getLetterGrade() {
    double m = studentMarks;
    if (m >= 80) return "A";
    else if (m >= 70) return "B";
    else if (m >= 60) return "C";
    else if (m >= 50) return "D";
    else return "F";
  }

  // Decision Making - Pass/fail status base on input grades (boolean decision)
  public String getStatus() {
    return studentMarks >= 50 ? "PASS" : "FAIL";
  }

  public String getStudentName () {
    return studentName;
  }

  public String getStudentID() {
    return studentID;
  }

  public double getStudentMarks() {
    return studentMarks;
  }

  public void setStudentName (String newName) {
    this.studentName = newName;
  }

  public void setStudentID (String newID) {
    this.studentID = newID;
  }

  // Updates and stores the mark
  public void setStudentMarks(double newMark) {
    this.studentMarks = newMark;
  }

  // Display all existing students in the records
  public String toString() {
    return studentName + " (ID: " + studentID + ") - Marks: " + studentMarks + " Grade: " + getLetterGrade() + " Status: " + getStatus();
  }
}
