package edu.iit.fenghuang.ssh.business.ebi;

import java.util.List;

import edu.iit.fenghuang.ssh.business.factory.BusinessFactory;
import edu.iit.fenghuang.ssh.vo.UserModel;
import edu.iit.fenghuang.ssh.vo.UserQueryModel;

public class EbiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserEbi userEbi = BusinessFactory.getUserEbi();
		UserQueryModel uqm = new UserQueryModel();
		uqm.setBalance1(Double.parseDouble("40"));
		uqm.setBalance2(90);
		List<UserModel> list = userEbi.queryByCondition(uqm);
		System.out.println(list);
	}	

}
