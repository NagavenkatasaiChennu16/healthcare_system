package inheritancemapping;

import javax.persistence.*;

@Entity
@Table(name = "person_table")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING,length = 100)
//@DiscriminatorValue(value = "person")

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
  
  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @GeneratedValue
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private String gender;
  
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }

}