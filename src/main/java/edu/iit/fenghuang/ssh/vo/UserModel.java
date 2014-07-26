package edu.iit.fenghuang.ssh.vo;

public class UserModel {
	private int userId;
	private String password;
	private String firstName;
	private String lastName;
	private double balance;
	private String email;
	private String submitFlag;
	public String getSubmitFlag() {
		return submitFlag;
	}
	public void setSubmitFlag(String submitFlag) {
		this.submitFlag = submitFlag;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
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
		UserModel other = (UserModel) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", password=" + password
				+ ", firstName=" + firstName + ", LastName=" + lastName
				+ ", balance=" + balance + ", email=" + email + "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
