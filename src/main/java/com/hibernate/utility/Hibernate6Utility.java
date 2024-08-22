package com.hibernate.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Hibernate6Utility {

	private static StandardServiceRegistry serviceRegistry;
	private static org.hibernate.SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			try {
				//StandardServiceRegistryBuilder(defaultValue :: hibernate.cfg.xml => else we need to give __.cfg.xml)
				serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources metadataSource = new MetadataSources(serviceRegistry);
				Metadata metadata = metadataSource.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
