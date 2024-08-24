package com.hibernate.utility.hibernate_utility_testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;
import com.hibernate.utility.Hibernate6Utility;


public class StudentInsert {

	public static void main(String[] args){
		SessionFactory sessionFactory = Hibernate6Utility.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction  transaction =  session.beginTransaction();
		Student student = new Student();
		student.setSno(1);
		student.setSname("HariOm");
		student.setSmarks(100.00);
		
		session.persist(student);
		transaction.commit();
		session.close();
	}
}
