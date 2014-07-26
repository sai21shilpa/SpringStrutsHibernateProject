package edu.iit.fenghuang.ssh.vo;

public class OrderModel {
	private int orderId;
	private int userId;
	private int goodId;
	private double unitPrice;
	private int number;
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderModel other = (OrderModel) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderModel [orderId=" + orderId + ", userId=" + userId
				+ ", goodId=" + goodId + ", unitPrice=" + unitPrice
				+ ", number=" + number + "]";
	}
	
}
