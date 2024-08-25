package com.hibernate.utility.hibernate_utility_testing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import com.hibernate.entity.Student;
import com.hibernate.utility.Hibernate6Utility;

public class StudentRead {

	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate6Utility.getSessionFactory();
		Session session = sessionFactory.openSession();

		SelectionQuery<Student> selectionQuery = session.createNativeQuery("from Student", Student.class);

		List<Student> studentList = selectionQuery.list();

		for (Student student : studentList)
			System.out.println(student);

		studentList.forEach(student -> System.out.println(student));

		studentList.forEach(System.out::println); // Method Reference

		session.close();

	}

}
