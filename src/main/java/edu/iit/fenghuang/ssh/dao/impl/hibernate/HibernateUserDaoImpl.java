package edu.iit.fenghuang.ssh.dao.impl.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.iit.fenghuang.ssh.dao.UserDAO;
import edu.iit.fenghuang.ssh.util.HibernateUtil;
import edu.iit.fenghuang.ssh.vo.UserModel;
import edu.iit.fenghuang.ssh.vo.UserQueryModel;

public class HibernateUserDaoImpl implements UserDAO {

	@Override
	public void createUser(UserModel um) {
		// TODO Auto-generated method stub
		HibernateUtil.add(um);
	}

	@Override
	public void updateUser(UserModel um) {
		// TODO Auto-generated method stub
		HibernateUtil.update(um);
	}

	@Override
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		UserModel um = new UserModel();
		um.setUserId(uid);
		HibernateUtil.delete(um);
	}

	@Override
	public UserModel queryById(int uid) {
		// TODO Auto-generated method stub
		Session session = null;  
		Transaction tx = null;  
		UserModel um = null;
		try {  
			session = HibernateUtil.getSession();  
			tx = session.beginTransaction();  
			String hql = "select o from UserModel o where o.userId = :uid";
			Query q = session.createQuery(hql);
			q.setInteger("uid", uid);
			um = (UserModel) q.uniqueResult();
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
		return um;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> queryAll() {
		// TODO Auto-generated method stub
		Session session = null;  
		Transaction tx = null;  
		List<UserModel> list = null;
		try {  
			session = HibernateUtil.getSession();  
			tx = session.beginTransaction();  
			Query q = session.createQuery("select o from UserModel o"); 
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
	public List<UserModel> queryByCondition(UserQueryModel uqm) {
		// TODO Auto-generated method stub
		Session session = null;  
		Transaction tx = null;  
		List<UserModel> list = null;
		try {  
			session = HibernateUtil.getSession();  
			tx = session.beginTransaction();  
			String hql = "select o from UserModel o where 1=1";
			hql = prepareHql(hql, uqm);
			Query q = session.createQuery(hql); 
			setValue(q, uqm);
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
	private String prepareHql(String hql, UserQueryModel uqm){		
		StringBuffer buffer = new StringBuffer(hql);
		if (uqm.getUserId() > 0)
			buffer.append(" and o.userId = :uid ");
		if (uqm.getFirstName()!=null && uqm.getFirstName().trim().length()>0)
			buffer.append(" and o.firstName like :fn ");
		if (uqm.getLastName()!=null && uqm.getLastName().trim().length()>0)
			buffer.append(" and o.lastName like :ln ");
		if (uqm.getEmail()!=null && uqm.getEmail().trim().length()>0)
			buffer.append(" and o.email like :email ");
		if (uqm.getBalance1() < uqm.getBalance2())
			buffer.append(" and o.balance >= :b1 and o.balance < :b2");
		return buffer.toString();
	}
	private void setValue(Query q, UserQueryModel uqm){
		if (uqm.getUserId() > 0)
			q.setInteger("uid", uqm.getUserId());
		if (uqm.getFirstName()!=null && uqm.getFirstName().trim().length()>0)
			q.setString("fn", uqm.getFirstName());
		if (uqm.getLastName()!=null && uqm.getLastName().trim().length()>0)
			q.setString("ln", uqm.getLastName());
		if (uqm.getEmail()!=null && uqm.getEmail().trim().length()>0)
			q.setString("email", uqm.getEmail());
		if (uqm.getBalance1() < uqm.getBalance2()){
			q.setDouble("b1", uqm.getBalance1());
			q.setDouble("b2", uqm.getBalance2());
		}
	}
}
