package edu.iit.fenghuang.ssh.vo;

import java.io.Serializable;
import java.util.List;

public class UserQueryModel extends UserModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double balance1;
	private double balance2;
	private List<UserModel> result;
	public List<UserModel> getResult() {
		return result;
	}

	public void setResult(List<UserModel> result) {
		this.result = result;
	}

	private String submitFlag;

	public String getSubmitFlag() {
		return submitFlag;
	}

	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}

	public double getBalance1() {
		return balance1;
	}

	public void setBalance1(double balance1) {
		this.balance1 = balance1;
	}

	public double getBalance2() {
		return balance2;
	}

	public void setBalance2(double balance2) {
		this.balance2 = balance2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"balance1="+balance1+",balance2="+balance2;
	}
}
