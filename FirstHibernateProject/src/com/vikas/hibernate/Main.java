package com.vikas.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {
public static void main(String [] args){
	Student_Info student=new Student_Info();
	student.setName("Vikas");
	student.setRollNo(23);
	//Create session factory object
	  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	  //getting session object from session factory
	  Session session = sessionFactory.openSession();
	  //getting transaction object from session object
	  session.beginTransaction();
	  
	  session.save(student);
	  System.out.println("Inserted Successfully");
	  session.getTransaction().commit();
	  session.close();
	  sessionFactory.close();
}
}