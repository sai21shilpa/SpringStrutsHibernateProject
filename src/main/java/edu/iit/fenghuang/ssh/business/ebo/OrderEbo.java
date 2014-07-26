package edu.iit.fenghuang.ssh.business.ebo;

import java.util.List;

import edu.iit.fenghuang.ssh.business.ebi.OrderEbi;
import edu.iit.fenghuang.ssh.dao.factory.JdbcDaoFactory;
import edu.iit.fenghuang.ssh.vo.OrderModel;
import edu.iit.fenghuang.ssh.vo.OrderQueryModel;

public class OrderEbo implements OrderEbi {

	@Override
	public void createOrder(OrderModel om) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getOrderDao().createOrder(om);
	}

	@Override
	public void updateOrder(OrderModel om) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getOrderDao().updateOrder(om);
	}

	@Override
	public void deleteOrder(int oid) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getOrderDao().deleteOrder(oid);
	}

	@Override
	public OrderModel queryById(int oid) {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getOrderDao().queryById(oid);
	}

	@Override
	public List<OrderModel> queryAll() {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getOrderDao().queryAll();
	}

	@Override
	public List<OrderModel> queryByCondition(OrderQueryModel oqm) {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getOrderDao().queryByCondition(oqm);
	}

}
