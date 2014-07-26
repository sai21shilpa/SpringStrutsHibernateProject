package edu.iit.fenghuang.ssh.business.ebi;

import java.util.List;

import edu.iit.fenghuang.ssh.vo.UserModel;
import edu.iit.fenghuang.ssh.vo.UserQueryModel;

public interface UserEbi {
	public void createUser(UserModel um);
	public void updateUser(UserModel um);
	public void deleteUser(int uid);
	public UserModel queryById(int uid);
	public List<UserModel> queryAll();
	public List<UserModel> queryByCondition(UserQueryModel uqm);
}
