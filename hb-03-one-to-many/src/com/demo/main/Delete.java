package com.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class Delete {

	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session=factory.openSession();
		try {
			int instructor_id=2;
			
			
			session.beginTransaction();
			Instructor instructor=session.get(Instructor.class,instructor_id);
			session.delete(instructor);
	
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
