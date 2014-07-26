package edu.iit.fenghuang.ssh.dao.factory;

import edu.iit.fenghuang.ssh.dao.GoodDAO;
import edu.iit.fenghuang.ssh.dao.OrderDAO;
import edu.iit.fenghuang.ssh.dao.UserDAO;
import edu.iit.fenghuang.ssh.dao.impl.jdbc.JdbcGoodDaoImpl;
import edu.iit.fenghuang.ssh.dao.impl.jdbc.JdbcOrderDaoImpl;
import edu.iit.fenghuang.ssh.dao.impl.jdbc.JdbcUserDaoImpl;

public class JdbcDaoFactory {
	private JdbcDaoFactory(){}
	public static UserDAO getUserDao(){
		return new JdbcUserDaoImpl();
	}
	public static GoodDAO getGoodDao(){
		return new JdbcGoodDaoImpl();
	}
	public static OrderDAO getOrderDao(){
		return new JdbcOrderDaoImpl();
	}
}
