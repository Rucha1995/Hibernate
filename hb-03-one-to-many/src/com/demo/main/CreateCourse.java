package com.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class CreateCourse {

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
			Course thecours1=new Course("GIS");
			Course thecourse2=new Course("Environment");
			
			theinstructor.add(thecours1);
			theinstructor.add(thecourse2);
			
			session.save(thecours1);
			session.save(thecourse2);
			session.getTransaction().commit();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
