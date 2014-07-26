package edu.iit.fenghuang.ssh.vo;

import java.util.List;

public class GoodQueryModel extends GoodModel {
	private double price1;
	private double price2;
	private String submitFlag;
	private List<GoodModel> result;
	public List<GoodModel> getResult() {
		return result;
	}
	public void setResult(List<GoodModel> result) {
		this.result = result;
	}
	public String getSubmitFlag() {
		return submitFlag;
	}
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}
	public double getPrice1() {
		return price1;
	}
	public void setPrice1(double price1) {
		this.price1 = price1;
	}
	public double getPrice2() {
		return price2;
	}
	public void setPrice2(double price2) {
		this.price2 = price2;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"result="+result;
	}
}
