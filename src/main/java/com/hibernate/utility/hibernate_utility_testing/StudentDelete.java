package com.hibernate.utility.hibernate_utility_testing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import com.hibernate.entity.Student;
import com.hibernate.utility.Hibernate6Utility;

public class StudentDelete {
	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate6Utility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		
		// Method 1
		Student student = new Student();
		student.setSno(111);
		session.remove(student);

		// Method 2
		Student student2 = session.get(Student.class, 111);
		session.remove(student2);

		// Method 3
		SelectionQuery<Student> selectionQuery = session.createNativeQuery("from Student where smarks >= marks",
				Student.class);
		selectionQuery.setParameter("smarks", 350);
		List<Student> studentList = selectionQuery.list();
		for(Student student3 : studentList)
			session.remove(student3);
		transaction.commit();
 		session.close();
	}
}