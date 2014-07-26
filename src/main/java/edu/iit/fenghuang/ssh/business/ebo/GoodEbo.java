package edu.iit.fenghuang.ssh.business.ebo;

import java.util.List;

import edu.iit.fenghuang.ssh.business.ebi.GoodEbi;
import edu.iit.fenghuang.ssh.dao.factory.HibernateDaoFactory;
import edu.iit.fenghuang.ssh.dao.factory.JdbcDaoFactory;
import edu.iit.fenghuang.ssh.vo.GoodModel;
import edu.iit.fenghuang.ssh.vo.GoodQueryModel;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
public class GoodEbo implements GoodEbi {

	@Override
	public void createGood(GoodModel um) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getGoodDao().createGood(um);
//		HibernateDaoFactory.getGoodDao().createGood(um);
	}

	@Override
	public void updateGood(GoodModel um) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getGoodDao().updateGood(um);
	}

	@Override
	public void deleteGood(int uid) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getGoodDao().deleteGood(uid);
	}

	@Override
	public GoodModel queryById(int gid) {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getGoodDao().queryById(gid);
	}

	@Override
	public List<GoodModel> queryAll() {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getGoodDao().queryAll();
	}

	@Override
	public List<GoodModel> queryByCondition(GoodQueryModel gqm) {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getGoodDao().queryByCondition(gqm);
	}

}
