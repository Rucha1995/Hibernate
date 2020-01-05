package com.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class GetInstructorCourses {

	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session=factory.openSession();
		try {
			
			session.beginTransaction();  
			
			//instructor id and add course this id
			int theID=1;
			
			Instructor theinstructor= session.get(Instructor.class, theID);
		
			System.out.println("Course: "+	theinstructor.getCourses());
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
