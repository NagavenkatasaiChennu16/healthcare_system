package inheritancemapping;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class InheritanceMappingDemo {
  
  public static void main(String[] args) {
    
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    
    SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession();
    
    Transaction transaction = session.beginTransaction();
    
    Person p = new Person();
    p.setName("KLEF");
    p.setGender("MALE");
    
    Faculty f = new Faculty();
    f.setName("VENKAT");
    f.setGender("MALE");
    f.setQualification("B.Tech.");
    f.setSalary(200000.0);
    f.setCourse("JFSD");
    
    Student s = new Student();
    s.setName("TITI");
    s.setGender("MALE");
    s.setProgram("B.Tech.");
    s.setCGPA(8.8);
    s.setBacklogs(1);
    
    session.save(p);
    session.save(f);
    session.save(s);
    
    System.out.println("Success...!!!");
    
    transaction.commit();
    session.close();
    sessionFactory.close();
    
  }

}