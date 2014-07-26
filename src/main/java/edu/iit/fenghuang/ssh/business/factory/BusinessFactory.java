package edu.iit.fenghuang.ssh.business.factory;

import edu.iit.fenghuang.ssh.business.ebi.GoodEbi;
import edu.iit.fenghuang.ssh.business.ebi.OrderEbi;
import edu.iit.fenghuang.ssh.business.ebi.UserEbi;
import edu.iit.fenghuang.ssh.business.ebo.GoodEbo;
import edu.iit.fenghuang.ssh.business.ebo.OrderEbo;
import edu.iit.fenghuang.ssh.business.ebo.UserEbo;

public class BusinessFactory {
	private BusinessFactory(){}
	public static GoodEbi getGoodEbi(){
		return new GoodEbo();
	}
	public static UserEbi getUserEbi(){
		return new UserEbo();
	}
	public static OrderEbi getOrderEbi(){
		return new OrderEbo();
	}
}
