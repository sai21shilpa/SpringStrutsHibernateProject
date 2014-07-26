package edu.iit.fenghuang.ssh.business.ebi;

import java.util.List;

import edu.iit.fenghuang.ssh.vo.OrderModel;
import edu.iit.fenghuang.ssh.vo.OrderQueryModel;

public interface OrderEbi {
	public void createOrder(OrderModel om);
	public void updateOrder(OrderModel om);
	public void deleteOrder(int oid);
	public OrderModel queryById(int oid);
	public List<OrderModel> queryAll();
	public List<OrderModel> queryByCondition(OrderQueryModel oqm);
}
