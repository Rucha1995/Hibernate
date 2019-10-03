package com.demo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class Create {

	public static void main(String[] args) {
	
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session=factory.openSession();
		try {
			//create instructor class object
			Instructor instructor=new Instructor("Rucha","Mahajan", "rucha@gmail.com");
			
			//create instructorDetail class object
			InstructorDetail instructorDetail=new InstructorDetail("http://www.coding.com", "code");
			
			//pass instructorDetail class value to instructor using setter and associate object 
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();
			
			//save instructor object with detail object bcz we use cascade  
			session.save(instructor);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
