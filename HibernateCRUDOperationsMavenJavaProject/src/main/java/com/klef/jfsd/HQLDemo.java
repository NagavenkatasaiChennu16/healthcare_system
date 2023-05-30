package com.klef.jfsd;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

//import org.hibernate.Query;
//import org.hibernate.Criteria;

public class HQLDemo 
{
   public static void main(String args[])
   {
	   HQLDemo demo = new HQLDemo();
	   //demo.viewallCustomers();
	  demo.viewallCustomersPartialObject();
	   //demo.AggregateFunctions();
	   //demo.updatedeletepostionalparameters();
	   //demo.updatedeletenamedparameters();
	  //demo.selectpostionalparameters();
	  demo.selectnamedparameters();

	   
   }
   public void viewallCustomers() //complete entity or object
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Query qry = session.createQuery("from Customer");
	   List<Customer> customerlist=qry.list();
	   System.out.println("***Using Complete Object***");
	   System.out.println("Total Records="+customerlist.size());
	   for(Customer customer : customerlist)
	   {
		   System.out.println(customer.toString());
	   }
	   session.close();
	   sessionFactory.close();
   }
   public void viewallCustomersPartialObject() // partial entity or object
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Query qry = session.createQuery("select c.id,c.name,c.salary,c.username,c.location from Customer c");
	   List<Object[]> customerlist=qry.list();
	   System.out.println("***Using Partial Object***");
	   System.out.println("Total Records="+customerlist.size());
	   for(Object[] obj:customerlist)
	   {
		   System.out.println("Customer ID="+obj[0]);
		   System.out.println("Customer Name="+obj[1]);
		   System.out.println("Customer Salary="+obj[2]);
		   System.out.println("Customer Username="+obj[3]);
		   System.out.println("Customer Location="+obj[4]);
		   System.out.println();
	   }
	   session.close();
	   sessionFactory.close();
   }
   
   public void AggregateFunctions()
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Query q1 = session.createQuery("select count(*) from Customer");
	   List list1 = q1.list();
	   System.out.println("***count(*)***");
	   System.out.println("Total Records Count="+list1.get(0));
	   
	   Query q2 = session.createQuery("select sum(salary) from Customer");
	   List list2 = q2.list();
	   System.out.println("***sum(salary)***");
	   System.out.println("Total Salary="+list2.get(0));
	   
	   Query q3 = session.createQuery("select min(age) from Customer");
	   List list3 = q3.list();
	   System.out.println("***min(age)***");
	   System.out.println("Mininum Age="+list3.get(0));
	   
	   Query q4 = session.createQuery("select max(age) from Customer");
	   List list4 = q4.list();
	   System.out.println("***max(age)***");
	   System.out.println("Maximum Age="+list4.get(0));
	   
	   
	   Query q5 = session.createQuery("select avg(salary) from Customer");
	   List list5 = q5.list();
	   System.out.println("***avg(salary)***");
	   System.out.println("Average Salary="+list5.get(0));
	   
	   session.close();
	   sessionFactory.close();
   }
   
   public void updatedeletepostionalparameters()
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Transaction transaction=session.beginTransaction();
	   
	   Query q1 = session.createQuery("update Customer set name=?1,salary=?2 where id=?3 ");
	   q1.setString(1, "Soumya Prasad");
	   q1.setDouble(2, 100000.00);
	   q1.setInteger(3, 105);
	   
	   int count = q1.executeUpdate();
	   System.out.println(count+" Record(s) Updated");
	   
	   Query q2 = session.createQuery("delete from Customer where id=?1");
	   q2.setInteger(1, 105);
	   
	   int count1 = q2.executeUpdate();
	   System.out.println(count1+" Record(s) Deleted");
	   transaction.commit();
	   session.close();
	   sessionFactory.close();
   }
   
   public void updatedeletenamedparameters()
   {
	   Configuration configuration=new Configuration();
	     configuration.configure("hibernate.cfg.xml");
	     
	     SessionFactory sessionFactory=configuration.buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     Transaction transaction=session.beginTransaction();
	     
	     Query q1 = session.createQuery("update Customer set name=:v1 , salary =:v2 where id = :v3");
	     q1.setParameter("v1", "Sravan");
	     q1.setParameter("v2", 50000.00);
	     q1.setParameter("v3", 101);
	     
	     int count = q1.executeUpdate();
	     System.out.println(count + " Record(s) Updated");
	     
	     Query q2 = session.createQuery("delete from Customer where id=:v1");
	     q2.setParameter("v1", 104);
	     
	     int count2 = q2.executeUpdate();
	     System.out.println(count2 + " Record(s) Deleted");
	
	     transaction.commit();
	     session.close();
	     sessionFactory.close();
   }
   public void selectpostionalparameters()
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Query qry = session.createQuery("from Customer where id=?1");
	   qry.setInteger(1, 103);
	   List<Customer> customerlist = qry.getResultList();
	   System.out.println("Total Records="+customerlist.size());
	   for(Customer c:customerlist)
	   {
		   System.out.println(c.toString());
	   }
	   
	   Query qry1 = session.createQuery("from Customer where username=?1 and password=?2");
	   qry1.setString(1, "klu123");
	   qry1.setString(2, "kluhfg");
	   List<Customer> customerlist1 = qry1.getResultList();
	   if(customerlist1.size()==1)
	   {
		   System.out.println("Customer Record Found");
		   System.out.println(customerlist1.get(0));
	   }
	   else
	   {
		   System.out.println("Customer Record Not Found");
	   }
	   
	   session.close();
	   sessionFactory.close();
   } 
   
   public void selectnamedparameters()
   {

	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Query qry1 = session.createQuery("from Customer where id=:v");
	   qry1.setParameter("v", 101);
	   List<Customer> customerlist = qry1.getResultList();
	   System.out.println("Total Records="+customerlist.size());
	   for(Customer c : customerlist)
	   {
		   System.out.println(c.toString());
	   }
	  
	   Query qry2 = session.createQuery("from Customer where username=:v1 and password=:v2");
	   qry2.setParameter("v1","klu123");
	   qry2.setParameter("v2", "klu");
	   
	   List<Customer> customerlist2 = qry2.getResultList();
	   if(customerlist2.size()==1)
	   {
		   System.out.println("Customer Record Found");
		   System.out.println(customerlist2.get(0));
	   }
	   else
	   {
		   System.out.println("Customer Record Not Found");
	   }
	   
	   
	   session.close();
	   sessionFactory.close();
   }
   
}
