package edu.iit.fenghuang.ssh.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="good_tbl")
public class GoodModel {
	@Id
	@Column(name="good_id")
	private int goodId;
	private String name;
	private String description;
	private double price;
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goodId;
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
		GoodModel other = (GoodModel) obj;
		if (goodId != other.goodId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GoodModel [goodId=" + goodId + ", name=" + name
				+ ", description=" + description + ", price=" + price + "]";
	}

}
