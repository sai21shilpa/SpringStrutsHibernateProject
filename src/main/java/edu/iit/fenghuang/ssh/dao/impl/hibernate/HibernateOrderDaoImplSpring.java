package edu.iit.fenghuang.ssh.dao.impl.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.iit.fenghuang.ssh.dao.OrderDAO;
import edu.iit.fenghuang.ssh.vo.OrderModel;
import edu.iit.fenghuang.ssh.vo.OrderQueryModel;

public class HibernateOrderDaoImplSpring implements OrderDAO {
	private SessionFactory sf = null;
	

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void createOrder(OrderModel om) {
		// TODO Auto-generated method stub
		HibernateTemplate ht = new HibernateTemplate(sf);
		ht.save(om);
	}

	@Override
	public void updateOrder(OrderModel om) {
		// TODO Auto-generated method stub
		HibernateTemplate ht = new HibernateTemplate(sf);
		ht.update(om);
	}

	@Override
	public void deleteOrder(int oid) {
		// TODO Auto-generated method stub
		HibernateTemplate ht = new HibernateTemplate(sf);
		OrderModel om = new OrderModel();
		om.setOrderId(oid);
		ht.delete(om);
	}

	@Override
	public OrderModel queryById(int oid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> queryByCondition(OrderQueryModel oqm) {
		// TODO Auto-generated method stub
		return null;
	}

}
