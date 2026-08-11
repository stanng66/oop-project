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
// Represents one student information (name, id, grades, grade calculation, pass/fail status)
public class StudentRecord {
  // Student with relevant information (name, ID, and grades)
  private String studentName;
  private String studentID;
  private double studentMark;

  // Constructor initializes student object
  public StudentRecord(String parmStudentName, String parmStudentID, double parmStudentgrades) {
    this.studentName = parmStudentName;
    this.studentID = parmStudentID;
    this.studentMark = parmStudentgrades;
  }

  // Decision Making - letter grade 
  public String letterGrade() { 
    double numericMark = studentMark;
    if (numericMark >= 80) return "A";
    else if (numericMark >= 70) return "B";
    else if (numericMark >= 60) return "C";
    else if (numericMark >= 50) return "D";
    else return "F";
  }

  // Pass/fail status base on input grades
  public String evaluateStatus() {   
    return studentMark >= 50 ? "PASS" : "FAIL";
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
  // Student mark getter and setter
  // ====================
  public double getStudentMark() {
    return studentMark;
  }

  public void setStudentMark(double newMark) {
    this.studentMark = newMark;
  }

  // ====================
  // Display all existing students in the records
  // ====================
  public String toString() {
    return studentName + " (ID: " + studentID + ") - Mark: " + studentMark + " Letter grade: " + letterGrade() + " Status: " + evaluateStatus();
  }
}
