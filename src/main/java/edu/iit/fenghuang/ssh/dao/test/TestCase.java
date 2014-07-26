package edu.iit.fenghuang.ssh.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.iit.fenghuang.ssh.dao.OrderDAO;
import edu.iit.fenghuang.ssh.vo.OrderModel;

public class TestCase {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		// GoodDAO goodDao = (GoodDAO) context.getBean("jdbcImpl");
		// GoodModel gm = new GoodModel();
		// gm.setGoodId(2);
		// gm.setName("erbi");
		// gm.setDescription("sanpao");
		//
		// goodDao.updateGood(gm);
		// goodDao.deleteGood(3);
		// GoodDAO goodDao = HibernateDaoFactory.getGoodDao();
		// GoodModel gm = new GoodModel();
		// gm.setGoodId(55);
		// goodDao.createGood(gm);
		// GoodQueryModel gqm = new GoodQueryModel();
		// gqm.setPrice1(80);
		// gqm.setPrice2(100);
		// System.out.println(goodDao.queryByCondition(gqm));
		OrderDAO orderDao = (OrderDAO) context.getBean("hOrderImpl");
		// System.out.println(orderrDao.queryById(18));
		OrderModel om = new OrderModel();
		for (int i = 1; i < 5; i++) {
			om.setOrderId(i);
			om.setUserId(i);
			om.setGoodId(i);
			orderDao.createOrder(om);
		}

		// orderrDao.updateOrder(om);
		// UserDAO userDao = DbFactory.getUserDao();
		// UserModel um = new UserModel();
		// for (int i = 1; i < 10; i++){
		// um.setUserId(i);
		// um.setPassword("pw"+i);
		// um.setFirstName("Jackson"+i);
		// um.setLastName("Aiden"+i);
		// um.setBalance(i*10);
		// um.setEmail("Jackson"+i+"@Aiden.com");
		// userDao.createUser(um);
		// }
		// userDao.deleteUser(5);
		// UserModel um = new UserModel();
		// um.setUserId(9);
		// um.setPassword("pw"+99);
		// um.setFirstName("Jackson"+99);
		// um.setLastName("Aiden"+99);
		// um.setBalance(99*10);
		// um.setEmail("Jackson"+99+"@Aiden.com");
		// userDao.updateUser(um);
		// UserModel um = null;
		// um = userDao.queryById(3);
		// System.out.println(um);
		// List<UserModel> list = null;
		// list = userDao.queryAll();
		// System.out.println(list);
		// List<UserModel> list = null;
		// UserQueryModel uqm = new UserQueryModel();
		// uqm.setFirstName("Jack");
		// list = userDao.queryByCondition(uqm);
		// System.out.println(list);

		// GoodDAO goodDao = DbFactory.getGoodDao();
		// GoodModel gm = new GoodModel();
		// for (int i = 1; i < 10; i++){
		// gm.setGoodId(i);
		// gm.setName("IIT"+i);
		// gm.setDescription("MTCC"+i);
		// gm.setPrice(i*10);
		// goodDao.createGood(gm);
		// }
		// goodDao.deleteGood(4);
		// GoodModel gm = new GoodModel();
		// gm.setGoodId(3);
		// gm.setName("UIC"+70);
		// gm.setDescription("UIC"+70);
		// gm.setPrice(70);
		// goodDao.updateGood(gm);
		// GoodModel gm = goodDao.queryById(3);
		// System.out.println(gm);
		// List<GoodModel> list = goodDao.queryAll();
		// System.out.println(list);
		// GoodQueryModel gqm = new GoodQueryModel();
		// gqm.setPrice1(50);
		// gqm.setPrice2(100);
		// List<GoodModel> list = goodDao.queryByCondition(gqm);
		// System.out.println(list);
		// OrderDAO orderDao = JdbcDaoFactory.getOrderDao();
		// OrderModel om = new OrderModel();
		// for (int i = 1; i < 10; i++){
		// om.setOrderId(i);
		// om.setGoodId(i);
		// om.setUserId(i);
		// om.setNumber(i*2);
		// om.setUnitPrice(99);
		// orderDao.createOrder(om);
		// }
		// orderDao.deleteOrder(4);
		// om.setOrderId(3);
		// om.setGoodId(99);
		// om.setUserId(2);
		// om.setNumber(99);
		// om.setUnitPrice(999);
		// orderDao.updateOrder(om);
		// System.out.println(orderDao.queryAll());
		// OrderQueryModel oqm = new OrderQueryModel();
		// oqm.setUserId(2);
		// System.out.println(orderDao.queryByCondition(oqm));
	}
}
