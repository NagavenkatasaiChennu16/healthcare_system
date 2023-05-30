package inheritancemapping;

import javax.persistence.*;

@Entity
@Table(name = "student_table")
@DiscriminatorValue(value="student")
public class Student extends Person
{
  private String program;
  private double CGPA;
  private int backlogs;
  
  public String getProgram() {
    return program;
  }
  public void setProgram(String program) {
    this.program = program;
  }
  public double getCGPA() {
    return CGPA;
  }
  public void setCGPA(double cGPA) {
    CGPA = cGPA;
  }
  public int getBacklogs() {
    return backlogs;
  }
  public void setBacklogs(int backlogs) {
    this.backlogs = backlogs;
  }
  
  
  
}