package edu.iit.fenghuang.ssh.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iit.fenghuang.ssh.dao.GoodDAO;
import edu.iit.fenghuang.ssh.util.HibernateUtil;
import edu.iit.fenghuang.ssh.vo.GoodModel;
import edu.iit.fenghuang.ssh.vo.GoodQueryModel;

public class HibernateGoodDaoImpl implements GoodDAO {

	@Override
	public void createGood(GoodModel gm) {
		// TODO Auto-generated method stub
		HibernateUtil.add(gm);
	}

	@Override
	public void updateGood(GoodModel gm) {
		// TODO Auto-generated method stub
		HibernateUtil.update(gm);
	}

	@Override
	public void deleteGood(int gid) {
		// TODO Auto-generated method stub
		GoodModel gm = new GoodModel();
		gm.setGoodId(gid);
		HibernateUtil.delete(gm);
	}

	@Override
	public GoodModel queryById(int gid) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		GoodModel om = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			String hql = "select o from GoodModel o where o.goodId = :gid";
			Query q = session.createQuery(hql);
			q.setInteger("gid", gid);
			om = (GoodModel) q.uniqueResult();
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
	public List<GoodModel> queryAll() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<GoodModel> list = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("select o from GoodModel o");
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
	public List<GoodModel> queryByCondition(GoodQueryModel gqm) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		List<GoodModel> list = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			String hql = "select o from GoodModel o where 1=1";
			hql = prepareHql(hql, gqm);
			Query q = session.createQuery(hql);
			setValue(q, gqm);
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

	private String prepareHql(String hql, GoodQueryModel gqm) {
		StringBuffer buffer = new StringBuffer(hql);
		if (gqm.getGoodId() > 0)
			buffer.append(" and o.orderId = :oid ");
		if (gqm.getName()!=null && gqm.getName().trim().length()>0)
			buffer.append(" and o.name like :name ");
		if (gqm.getDescription()!=null && gqm.getDescription().trim().length()>0)
			buffer.append(" and o.description like :description ");
		if (gqm.getPrice1() < gqm.getPrice2())
			buffer.append(" and o.price >= :price1 and o.price < :price2");
		return buffer.toString();
	}

	private void setValue(Query q, GoodQueryModel gqm) {
		if (gqm.getGoodId() > 0)
			q.setInteger("oid", gqm.getGoodId());
		if (gqm.getName()!=null && gqm.getName().trim().length()>0)
			q.setString("name", gqm.getName());
		if (gqm.getDescription()!=null && gqm.getDescription().trim().length()>0)
			q.setString("description", gqm.getDescription());
		if (gqm.getPrice1() < gqm.getPrice2()){
			q.setDouble("price1", gqm.getPrice1());
			q.setDouble("price2", gqm.getPrice2());
		}
	}
}
