package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreareStudentdemo {

	public static void main(String[] args) {
	
		//creaet a session factroy 
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create student object
			System.out.println("Creating a new Student Object");
			Student tmpStudent=new Student("Amit","Singh","aks@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student...");
			session.save(tmpStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

}
