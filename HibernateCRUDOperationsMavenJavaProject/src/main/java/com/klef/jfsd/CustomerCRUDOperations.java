package com.klef.jfsd;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class CustomerCRUDOperations 
{
   public static void main(String args[])
   {
	   CustomerCRUDOperations crudOperations=new CustomerCRUDOperations();
       crudOperations.insertCustomer();
       //crudOperations.deleteCustomer();
	   //crudOperations.viewCustomerById();
	   //crudOperations.updateCustomer();
   }
   public void insertCustomer()
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Transaction transaction=session.beginTransaction();
	   
	   Customer customer=new Customer();
	   customer.setId(102);
	   customer.setName("Sai");
	   customer.setGender("MALE");
	   customer.setUsername("SAI");
	   customer.setPassword("saiv");
	   customer.setAge(29.50);
	   customer.setSalary(79000.00);
	   customer.setLocation("Vijayawada");
	   customer.setMarriedstatus(false);

	   session.save(customer);
	   transaction.commit();
	   System.out.println("Customer Object Saved Successfully");
	   
	   session.close();
	   sessionFactory.close();
	   
   }
   public void deleteCustomer()
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Transaction transaction=session.beginTransaction();
	   Object obj=session.get(Customer.class, 101);
	   Customer customer=(Customer)obj;
	   if(customer!=null)
	   {
		   session.delete(customer); 
		   transaction.commit();
		   System.out.println("Customer Object Deleted Successfully");
	   }
	   else
	   {
		   System.out.println("Customer Object Not Found");
	   }
	   
	   
	   session.close();
	   sessionFactory.close();
	   
	   
	   
   }
   public void viewCustomerById()
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Object obj=session.get(Customer.class, 100);
	   Customer customer=(Customer)obj;
	  
	   if(customer!=null)
	   {
		   System.out.println(customer.getId());
		   System.out.println(customer.getName());
		   System.out.println(customer.getGender());
		   System.out.println(customer.getUsername());
		   System.out.println(customer.getPassword());
		   System.out.println(customer.getAge());
		   System.out.println(customer.getSalary());
		   System.out.println(customer.getLocation());
		   System.out.println(customer.isMarriedstatus());
	   }
	   else
	   {
		   System.out.println("Customer Object Not Found");
	   }
	   session.close();
	   sessionFactory.close();
	   
   }
   public void updateCustomer()
   {
	   Configuration configuration=new Configuration();
	   configuration.configure("hibernate.cfg.xml");
	   
	   SessionFactory sessionFactory=configuration.buildSessionFactory();
	   Session session=sessionFactory.openSession();
	   
	   Transaction transaction=session.beginTransaction();
	   Object obj=session.get(Customer.class, 102);
	   Customer customer=(Customer)obj;
	   if(customer!=null) 
	   {
		   customer.setUsername("cbithyd123");
		   customer.setSalary(25000.50);
		   customer.setMarriedstatus(true);
		   customer.setLocation("Durgamcheruvu");
		   
		   transaction.commit();
		   System.out.println("Customer Object Updated Successfully");
		   
	   }
	   else
	   {
		   System.out.println("Customer Object Not Found");
	   }
	   session.close();
	   sessionFactory.close();
   }
   
   
   
}
