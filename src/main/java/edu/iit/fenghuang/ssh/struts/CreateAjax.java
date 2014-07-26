package edu.iit.fenghuang.ssh.struts;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

import edu.iit.fenghuang.ssh.business.ebi.GoodEbi;
import edu.iit.fenghuang.ssh.business.factory.BusinessFactory;
import edu.iit.fenghuang.ssh.vo.GoodModel;

public class CreateAjax extends ActionSupport{
	private int goodId;
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		GoodEbi goodEbi = BusinessFactory.getGoodEbi();
		GoodModel gm = goodEbi.queryById(goodId);
		System.out.println(gm);
		if (gm.getGoodId() != 0)
			inputStream = new ByteArrayInputStream("goodId already exists".getBytes("utf-8"));
		else 
			inputStream = new ByteArrayInputStream("goodId ok".getBytes("utf-8"));
		return this.SUCCESS;
	}

}
