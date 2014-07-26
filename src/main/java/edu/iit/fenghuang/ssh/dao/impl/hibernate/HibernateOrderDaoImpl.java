package edu.iit.fenghuang.ssh.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iit.fenghuang.ssh.dao.OrderDAO;
import edu.iit.fenghuang.ssh.util.HibernateUtil;
import edu.iit.fenghuang.ssh.vo.OrderModel;
import edu.iit.fenghuang.ssh.vo.OrderQueryModel;

public class HibernateOrderDaoImpl implements OrderDAO {

	@Override
	public void createOrder(OrderModel om) {
		// TODO Auto-generated method stub
		HibernateUtil.add(om);
	}

	@Override
	public void updateOrder(OrderModel om) {
		// TODO Auto-generated method stub
		HibernateUtil.update(om);
	}

	@Override
	public void deleteOrder(int oid) {
		// TODO Auto-generated method stub
		OrderModel om = new OrderModel();
		om.setOrderId(oid);
		HibernateUtil.delete(om);
	}

	@Override
	public OrderModel queryById(int oid) {
		// TODO Auto-generated method stub
		Session session = null;  
		Transaction tx = null;  
		OrderModel om = null;
		try {  
			session = HibernateUtil.getSession();  
			tx = session.beginTransaction();  
			// no session, better to use HQL
//			om = (OrderModel)session.load(OrderModel.class, oid);
			String hql = "select o from OrderModel o where o.orderId = :oid";
			Query q = session.createQuery(hql);
			q.setInteger("oid", oid);
			om = (OrderModel) q.uniqueResult();
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
		return om;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderModel> queryAll() {
		// TODO Auto-generated method stub
		Session session = null;  
		Transaction tx = null;  
		List<OrderModel> list = null;
		try {  
			session = HibernateUtil.getSession();  
			tx = session.beginTransaction();  
			Query q = session.createQuery("select o from OrderModel o"); 
			list = q.list();
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
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderModel> queryByCondition(OrderQueryModel oqm) {
		// TODO Auto-generated method stub
		Session session = null;  
		Transaction tx = null;  
		List<OrderModel> list = null;
		try {  
			session = HibernateUtil.getSession();  
			tx = session.beginTransaction();  
			String hql = "select o from OrderModel o where 1=1";
			hql = prepareHql(hql, oqm);
			Query q = session.createQuery(hql); 
			setValue(q, oqm);
			list = q.list();
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
		return list;
	}
	private String prepareHql(String hql, OrderQueryModel oqm){
		StringBuffer buffer = new StringBuffer(hql);
		if (oqm.getOrderId() > 0)
			buffer.append(" and o.orderId = :oid ");
		if (oqm.getGoodId() > 0)
			buffer.append(" and o.goodId = :gid ");
		if (oqm.getUserId() > 0)
			buffer.append(" and o.userId = :uid ");

		return buffer.toString();
	}
	private void setValue(Query q, OrderQueryModel oqm){
		if (oqm.getOrderId() > 0)
			q.setInteger("oid", oqm.getOrderId());
		if (oqm.getGoodId() > 0)
			q.setInteger("gid", oqm.getGoodId());
		if (oqm.getUserId() > 0)
			q.setInteger("uid", oqm.getUserId());
	}
}
