package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentdemo {

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
			 
			//delete the Student
			//System.out.println("Deletring Student:: "+myStudent);
			//session.delete(myStudent);
			
			//delete student id =2
			System.out.println("deleting Dtudent with id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			factory.close();
		}
	}

}
