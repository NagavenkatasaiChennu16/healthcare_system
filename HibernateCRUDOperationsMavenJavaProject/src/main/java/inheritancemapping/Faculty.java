package inheritancemapping;

import javax.persistence.*;

@Entity
@Table(name="faculty_table")
@DiscriminatorValue(value="faculty")
public class Faculty extends Person
{
  private String qualification;
  private double salary;
  private String course;
  
  public String getQualification() {
    return qualification;
  }
  public void setQualification(String qualification) {
    this.qualification = qualification;
  }
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  public String getCourse() {
    return course;
  }
  public void setCourse(String course) {
    this.course = course;
  }
}