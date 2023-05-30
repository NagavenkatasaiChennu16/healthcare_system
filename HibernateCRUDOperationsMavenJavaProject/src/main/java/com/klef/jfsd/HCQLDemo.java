package com.klef.jfsd;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HCQLDemo 
{
  public static void main(String args[])
  {
	  HCQLDemo hcqlDemo  = new HCQLDemo();
	  
		 //hcqlDemo.RestrictionsDemo();
		 //hcqlDemo.ProjectionswithAggregateFunctions();
		 //hcqlDemo.ProjectionswithProperties();
		 //hcqlDemo.OrderDemo();
	      //hcqlDemo.HCQLConditions();
	       hcqlDemo.HCQLall();
		 }
 
 
  public void RestrictionsDemo()
  {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
      Session session=sessionFactory.openSession();
      Criteria criteria1 = session.createCriteria(Customer.class); 
      criteria1.add(Restrictions.eq("id",102));
      criteria1.add(Restrictions.eq("name","sravan"));//name=Sravan
      List<Customer> list1 = criteria1.list();
      System.out.println("Total Records="+list1.size());
      if(list1.size()>0)
      {
    	  for(Customer c:list1)
    	  {
    		  System.out.println(c.toString());
    	  }
      }
      else
      {
    	  System.out.println("Customer Data Not Found");
      }
      
      
      Criteria criteria2 = session.createCriteria(Customer.class); 
      criteria2.add(Restrictions.lt("salary",75000.00));//salary<75000.00
      List<Customer> list2 = criteria2.list();
      System.out.println("Total Records="+list2.size());
      if(list2.size()>0)
      {
    	  for(Customer c:list2)
    	  {
    		  System.out.println(c.toString());
    	  }
      }
      else
      {
    	  System.out.println("Customer Data Not Found");
      }
  Criteria criteria3 = session.createCriteria(Customer.class); 
 criteria3.add(Restrictions.gt("salary",50000.00));//salary>50000.00 (greater than)
 List<Customer> list3 = criteria3.list();
 System.out.println("Total Records="+list3.size());
      if(list3.size()>0)
      {
    	  for(Customer c:list3)
    	  {
    		  System.out.println(c.toString());
    	  }
      }
      else
      {
    	  System.out.println("Customer Data Not Found");
      }
 Criteria criteria4 = session.createCriteria(Customer.class); 
 criteria4.add(Restrictions.le("salary",50000.00));//salary<=50000.00 (less than or equal to)
 List<Customer> list4 = criteria4.list();
 if(list4.size()>0)
      {
    	  for(Customer c:list4)
    	  {
    		  System.out.println(c.toString());
    	  }
      }
      else
      {
    	  System.out.println("Customer Data Not Found");
      }
//remaining code to print list

 Criteria criteria5 = session.createCriteria(Customer.class); 
 criteria5.add(Restrictions.ge("salary",50000.00));//salary>=50000.00 (greater than or equal to)
 List<Customer> list5 = criteria5.list();
 if(list5.size()>0)
      {
    	  for(Customer c:list5)
    	  {
    		  System.out.println(c.toString());
    	  }
      }
      else
      {
    	  System.out.println("Customer Data Not Found");
      }
//remaining code to print list

 Criteria criteria6 = session.createCriteria(Customer.class); 
 criteria6.add(Restrictions.between("salary",10000.00,70000.00));//salary>=10000.00 and salary<=70000.00
 List<Customer> list6 = criteria6.list();
 if(list6.size()>0)
      {
    	  for(Customer c:list6)
    	  {
    		  System.out.println(c.toString());
    	  }
      }
      else
      {
    	  System.out.println("Customer Data Not Found");
      }
//remaining code to print list

 Criteria criteria7 = session.createCriteria(Customer.class); 
 criteria7.add(Restrictions.ne("salary",50000.00));//salary!=50000.00 (not equal)
 List<Customer> list7 = criteria7.list();
 if(list7.size()>0)
      {
    	  for(Customer c:list7)
    	  {
    		  System.out.println(c.toString());
    	  }
      }
      else
      {
    	  System.out.println("Customer Data Not Found");
      }
 Criteria criteria8 = session.createCriteria(Customer.class); 
 criteria8.add(Restrictions.idEq(101)); // id = 101
List<Customer> list8 = criteria8.list();
System.out.println("Total Records="+list8.size());
 if(list8.size()>0)
 {
   System.out.println("Customer Data Found");
   for(Customer Customer:list8)
   {
     System.out.println(Customer.toString());
   }
 }
 else
 {
   System.out.println("Customer Data Not Found");
 }
 
 
 Criteria criteria9 = session.createCriteria(Customer.class); 
 criteria9.add(Restrictions.isNotNull("salary"));
 //criteria9.add(Restrictions.isNull("salary"));
// criteria9.add(Restrictions.eqOrIsNull("salary", 30000.00));
// criteria9.add(Restrictions.neOrIsNotNull("salary", 30000.00));
 criteria9.add(Restrictions.isNull("salary"));
List<Customer> list9 = criteria9.list();
System.out.println("Total Records="+list9.size());
 if(list9.size()>0)
 {
   System.out.println("Customer Data Found");
   for(Customer Customer:list9)
   {
     System.out.println(Customer.toString());
   }
 }
 else
 {
   System.out.println("Customer Data Not Found");
 }
 
 Criteria criteria10 = session.createCriteria(Customer.class); 
 //criteria10.add(Restrictions.like("name", "S%"));
 criteria10.add(Restrictions.like("name", "%n"));
 //criteria10.add(Restrictions.like("name", "____"));
List<Customer> list10 = criteria10.list();
System.out.println("Total Records="+list10.size());
 if(list10.size()>0)
 {
   System.out.println("Customer Data Found");
   for(Customer Customer:list10)
   {
     System.out.println(Customer.toString());
   }
 }
 else
 {
   System.out.println("Customer Data Not Found");
 }
 
 Criteria criteria11= session.createCriteria(Customer.class); 
 //criteria11.add(Restrictions.in("id", new Integer[] {101,102,105}));
 criteria11.add(Restrictions.in("name", new String[] {"CBIT","KLU","Sravan"}));
 List<Customer> list11 = criteria11.list();
System.out.println("Total Records="+list11.size());
 if(list11.size()>0)
 {
   System.out.println("Customer Data Found");
   for(Customer Customer:list11)
   {
     System.out.println(Customer.toString());
   }
 }
 else
 {
   System.out.println("Customer Data Not Found");
 }

 session.close();
 sessionFactory.close();
}
  public void ProjectionswithAggregateFunctions()
  {
    Configuration configuration=new Configuration();
    configuration.configure("hibernate.cfg.xml");
         
    SessionFactory sessionFactory=configuration.buildSessionFactory();
    Session session=sessionFactory.openSession();
    
    Criteria c1 = session.createCriteria(Customer.class);
    c1.setProjection(Projections.rowCount());
    List list1 = c1.list();
    System.out.println("Total Records Count="+list1.get(0));
    
    Criteria c2 = session.createCriteria(Customer.class);
    c2.setProjection(Projections.count("salary"));
    List list2 = c2.list();
    System.out.println("Total Records Count="+list2.get(0));
    
    Criteria c3 = session.createCriteria(Customer.class);
    c3.setProjection(Projections.min("age"));
    List list3 = c3.list();
    System.out.println("Minimum Age="+list3.get(0));
    
    Criteria c4 = session.createCriteria(Customer.class);
    c4.setProjection(Projections.max("age"));
    List list4 = c4.list();
    System.out.println("Maximum Age="+list4.get(0));
    
    Criteria c5 = session.createCriteria(Customer.class);
    c5.setProjection(Projections.sum("salary"));
    List list5 = c5.list();
    System.out.println("Total Salary="+list5.get(0));
    
    Criteria c6 = session.createCriteria(Customer.class);
    c6.setProjection(Projections.avg("salary"));
    List list6 = c6.list();
    System.out.println("Average Salary="+list6.get(0));
    
    session.close();
    sessionFactory.close();
  }
  public void ProjectionswithProperties()
  {
    Configuration configuration=new Configuration();
    configuration.configure("hibernate.cfg.xml");
           
    SessionFactory sessionFactory=configuration.buildSessionFactory();
    Session session=sessionFactory.openSession();
     
    Criteria c1 = session.createCriteria(Customer.class);
    c1.setProjection(Projections.id());
    List list1 = c1.list();
    System.out.println("Total Records Size="+list1.size());
    for(int i=0;i<list1.size();i++)
    {
      System.out.println(list1.get(i));
    }
    
    Criteria c2 = session.createCriteria(Customer.class);
    c2.setProjection(Projections.property("name"));
    List list2 = c2.list();
    System.out.println("Total Records Size="+list2.size());
    for(int i=0;i<list2.size();i++)
    {
      System.out.println(list2.get(i));
    }
    
    Criteria c3 = session.createCriteria(Customer.class);
    c3.setProjection(Projections.projectionList().add(Projections.property("id")).add(Projections.property("name")).add(Projections.property("salary")) );
    List<Object[]> list3 = c3.list();
    System.out.println("Total Records Size="+list3.size());
      for(Object[] obj:list3)
      {
        System.out.println(obj[0]+","+obj[1]+","+obj[2]);
      }
      
    session.close();
    sessionFactory.close();
  }
  public void OrderDemo() // asc or desc
  {
    Configuration configuration=new Configuration();
    configuration.configure("hibernate.cfg.xml");
           
    SessionFactory sessionFactory=configuration.buildSessionFactory();
    Session session=sessionFactory.openSession();
    
    Criteria c = session.createCriteria(Customer.class);
    c.addOrder(Order.asc("name"));
    //c.addOrder(Order.desc("name"));
    List<Customer> customerlist = c.list();
    System.out.println("Total Records Size="+customerlist.size());
    for(Customer customer:customerlist)
    {
      System.out.println(customer.toString());
    }
    
    session.close();
    sessionFactory.close();
  }
  public void HCQLConditions()
  {
	  Configuration configuration=new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	           
	    SessionFactory sessionFactory=configuration.buildSessionFactory();
	    Session session=sessionFactory.openSession();
	    
	    Criteria c = session.createCriteria(Customer.class);
	    c.add(Restrictions.not(Restrictions.like("name","s%")));
	    c.add(Restrictions.and(Restrictions.lt("salary",3000000.00),Restrictions.like("name","s%")));
	    
	    List<Customer> list = c.list();
	    System.out.println("Total Records Size="+list.size());
	    if(list.size()>0)
	    {
	    	for(Customer customer:list)
	    	{
	    		System.out.println(customer.toString());
	    	}
	    }
	    else
	    {
	    	System.out.println("Customer not found");
	    }
	    session.close();
	    sessionFactory.close();
  }
  public void HCQLall()
  {
	    Configuration configuration=new Configuration();
	    configuration.configure("hibernate.cfg.xml");     
	    SessionFactory sessionFactory=configuration.buildSessionFactory();
	    Session session=sessionFactory.openSession();    
	    Criteria c = session.createCriteria(Customer.class);
	    c.add(Restrictions.gt("salary",30000.00));
	    c.setProjection(Projections.property("name"));
	    c.addOrder(Order.desc("name"));
	    List list = c.list();
	    System.out.println("Total Records Size="+list.size());
	    for(int i=0;i<list.size();i++)
	    {
	      System.out.println(list.get(i));
	    }
	    
	    session.close();
	    sessionFactory.close();
  }
}
