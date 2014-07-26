package edu.iit.fenghuang.ssh.struts;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.iit.fenghuang.ssh.dao.GoodDAO;
import edu.iit.fenghuang.ssh.vo.GoodModel;
import edu.iit.fenghuang.ssh.vo.GoodQueryModel;
public class GoodAction extends ActionSupport {
	GoodDAO goodDao = null;
	
	public GoodDAO getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GoodDAO goodDao) {
		this.goodDao = goodDao;
	}
	private GoodQueryModel gqm;
	private GoodQueryModel ret = new GoodQueryModel();
	private String submitFlag;
	public String getSubmitFlag() {
		return submitFlag;
	}

	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}

	public GoodQueryModel getRet() {
		return ret;
	}

	public void setRet(GoodQueryModel ret) {
		this.ret = ret;
	}

	public GoodQueryModel getGqm() {
		return gqm;
	}

	public void setGqm(GoodQueryModel gqm) {
		this.gqm = gqm;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		goodDao goodDao = BusinessFactory.getgoodDao();
		switch(submitFlag){
		case "toList":
			System.out.println("--->toList");
			List<GoodModel> list = goodDao.queryAll();
			ret.setResult(list);
			return "toList";
		case "toCreate":
			System.out.println("--->toCreate");
			goodDao.createGood(gqm2gm(gqm));
			List<GoodModel> list2 = goodDao.queryAll();
			ret.setResult(list2);
			return "toList";
		case "toUpdate":
			System.out.println("--->toUpdate");
			System.out.println(gqm);
			GoodModel gm = goodDao.queryById(gqm.getGoodId());
			ret = gm2gqm(gm);
			System.out.println(gm);
			return "toUpdate";
		case "doUpdate":
			System.out.println("--->doUpdate");
			goodDao.updateGood(gqm2gm(gqm));
			List<GoodModel> list5 = goodDao.queryAll();
			ret.setResult(list5);
			return "toList";
		case "toDelete":
			System.out.println("--->toDelete");
			goodDao.deleteGood(gqm.getGoodId());
			List<GoodModel> list4 = goodDao.queryAll();
			ret.setResult(list4);
			return "toList";
		case "toQuery":
			System.out.println("--->toQuery");
			System.out.println(gqm);
			List<GoodModel> list3 = goodDao.queryByCondition(gqm);
			System.out.println(list3);
			ret.setResult(list3);
			return "toQueryResult";
		}
		return "toList";
	}
	private GoodQueryModel gm2gqm(GoodModel gm){
		GoodQueryModel gqm = new GoodQueryModel();
		gqm.setGoodId(gm.getGoodId());
		gqm.setName(gm.getName());
		gqm.setDescription(gm.getDescription());
		gqm.setPrice(gm.getPrice());
		return gqm;
		
	}
	private GoodModel gqm2gm(GoodQueryModel gqm){
		GoodModel gm = new GoodModel();
		gm.setGoodId(gqm.getGoodId());
		gm.setName(gqm.getName());
		gm.setDescription(gqm.getDescription());
		gm.setPrice(gqm.getPrice());
		return gm;
	}

}
