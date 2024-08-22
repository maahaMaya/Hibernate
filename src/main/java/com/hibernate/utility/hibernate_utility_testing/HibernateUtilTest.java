package com.hibernate.utility.hibernate_utility_testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.utility.Hibernate6Utility;

public class HibernateUtilTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = Hibernate6Utility.getSessionFactory();
		Session session = sessionFactory.openSession();
		String mySqlVersion = (String) session.createNativeQuery("SELECT VERSION()").getSingleResult();
		System.out.println("MYSQL Version :: " + mySqlVersion);
	}
}
