package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentdemo {

	public static void main(String[] args) {
	
		//creaet a session factroy 
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			int studentId=1;
			
			//now get a new session and start transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve Student based on Id's
			System.out.println("\nGetting student with id: "+studentId);
			Student myStudent=session.get(Student.class,studentId);
			
			System.out.println("Updating Student");
			myStudent.setFirstName("Sonali");
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			//new Code
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all student
			System.out.println("Updating email for all student");
			session.createQuery("update Student set email='anshurani@gf.in'").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

}
