package edu.iit.fenghuang.ssh.dao.factory;

import edu.iit.fenghuang.ssh.dao.GoodDAO;
import edu.iit.fenghuang.ssh.dao.OrderDAO;
import edu.iit.fenghuang.ssh.dao.UserDAO;
import edu.iit.fenghuang.ssh.dao.impl.hibernate.HibernateGoodDaoImpl;
import edu.iit.fenghuang.ssh.dao.impl.hibernate.HibernateOrderDaoImpl;
import edu.iit.fenghuang.ssh.dao.impl.hibernate.HibernateUserDaoImpl;

public class HibernateDaoFactory {
	private HibernateDaoFactory(){}
	public static UserDAO getUserDao(){
		return new HibernateUserDaoImpl();
	}
	public static GoodDAO getGoodDao(){
		return new HibernateGoodDaoImpl();
	}
	public static OrderDAO getOrderDao(){
		return new HibernateOrderDaoImpl();
	}
}
