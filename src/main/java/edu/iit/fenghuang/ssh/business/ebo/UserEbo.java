package edu.iit.fenghuang.ssh.business.ebo;

import java.util.List;

import edu.iit.fenghuang.ssh.business.ebi.UserEbi;
import edu.iit.fenghuang.ssh.dao.factory.JdbcDaoFactory;
import edu.iit.fenghuang.ssh.vo.UserModel;
import edu.iit.fenghuang.ssh.vo.UserQueryModel;

public class UserEbo implements UserEbi {

	@Override
	public void createUser(UserModel um) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getUserDao().createUser(um);
	}

	@Override
	public void updateUser(UserModel um) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getUserDao().updateUser(um);
	}

	@Override
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		JdbcDaoFactory.getUserDao().deleteUser(uid);
	}

	@Override
	public UserModel queryById(int uid) {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getUserDao().queryById(uid);
	}

	@Override
	public List<UserModel> queryAll() {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getUserDao().queryAll();
	}

	@Override
	public List<UserModel> queryByCondition(UserQueryModel uqm) {
		// TODO Auto-generated method stub
		return JdbcDaoFactory.getUserDao().queryByCondition(uqm);
	}

}
