package com.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class ReadDataBidirectional {

	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session=factory.openSession();
		try {
			
			session.beginTransaction();
			int theID= 1;
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, theID);
			System.out.println("instructor detail"+instructorDetail);
			
			System.out.println("Related Instructor information:"+ instructorDetail.getInstructor());
			
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
