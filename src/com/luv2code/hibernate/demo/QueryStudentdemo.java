package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentdemo {

	public static void main(String[] args) {
	
		//creaet a session factroy 
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//start transaction
			session.beginTransaction();
			
			//Query Student
			List<Student> theStudents=session.createQuery("from Student").list();
			
			//display the Student
			displayStudents(theStudents);
			
			//query student firstName="Tanya"
			theStudents=session.createQuery("from Student s where s.firstName='Tanya'").list();
			
			//display the Student
			System.out.println("\n\nStudent whos FirstName is Tanya");
			displayStudents(theStudents);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student theStudent:theStudents) {
			System.out.println(theStudent);
		}
	}

}
