package com.hibernate.utility.hibernate_utility_testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import com.hibernate.entity.Student;
import com.hibernate.utility.Hibernate6Utility;

public class StudentUpdate {

	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate6Utility.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Method 1
		Student student = session.get(Student.class, 111);
		student.setSmarks(765);
		session.merge(student);

		// Method 2 -> HQL(applied on Modal(POJO class), not on Table)
		MutationQuery mutationQuery = session
				.createMutationQuery("update Student set smarks = :smarks where sname = :sname");
		mutationQuery.setParameter("smarks", 564);
		mutationQuery.setParameter("sname", "HariOm");
		mutationQuery.executeUpdate();
		transaction.commit();
		session.close();

	}

}
