package edu.iit.fenghuang.ssh.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	// this is for Hibernate 4.3 code : change pom if want to change versions
	static {
		try {
			Configuration cfg = new Configuration()
			.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = sb.build();
			sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static void add(Object obj) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) { // 如果存在事务，则回滚
				tx.rollback();
			}
			throw e; // 抛出异常
		} finally {
			if (session != null) // 如果session存在，则关闭
				session.close();
		}
	}

	public static void update(Object obj) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) { // 如果存在事务，则回滚
				tx.rollback();
			}
			throw e; // 抛出异常
		} finally {
			if (session != null) // 如果session存在，则关闭
				session.close();
		}
	}
	public static void delete(Object obj) {  
		Session session = null;  
		Transaction tx = null;  
		try {  
			session = HibernateUtil.getSession();  
			tx = session.beginTransaction();  
			session.delete(obj);  
			tx.commit();  
		} catch (HibernateException e) {  
			if (tx != null) { // 如果存在事务，则回滚  
				tx.rollback();  
			}  
			throw e; // 抛出异常  
		} finally {  
			if (session != null) // 如果session存在，则关闭  
				session.close();  
		}  
	}
}
