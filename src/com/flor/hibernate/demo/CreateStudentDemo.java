package com.flor.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.flor.hibernate.demo.entity.Student;



public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();	
	
	try {
		System.out.println("Creating new student obj");
		Student tempStudent = new Student("Flor", "Ferreyra", "florferreyra16@gmail.com");
		session.beginTransaction();
		System.out.println("Saving the Student");
		session.save(tempStudent);
		session.getTransaction().commit();
		System.out.println("Done!");
		
	}
	finally {
		factory.close();
		}
	}
}
