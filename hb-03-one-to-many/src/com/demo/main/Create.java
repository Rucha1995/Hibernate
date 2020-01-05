package com.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class Create {

	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		Session session=factory.openSession();
		try {
			Instructor instructor=new Instructor("Miti","Pancholi", "miti@gmail.com");
			InstructorDetail instructorDetail=new InstructorDetail("http://www.environment.com", "environment");
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();  
			session.save(instructor);
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
