package com.cg.zerodhaclone.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="shares_tbl")
public class Shares {
	
	@Id
	@SequenceGenerator(name = "ShareIdGeneration",
	sequenceName = "shareSequence", initialValue = 10000, allocationSize = 1)
	@GeneratedValue(generator = "ShareIdGeneration")
	private long id;
	private int quantity;
	private String companyName;
	private LocalDate buyDate;
	private LocalDate sellDate;
	private float price;
	
	@ManyToOne
	private Trader trader;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public LocalDate getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(LocalDate buyDate) {
		this.buyDate = buyDate;
	}
	public LocalDate getSellDate() {
		return sellDate;
	}
	public void setSellDate(LocalDate sellDate) {
		this.sellDate = sellDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Shares() {
		super();
	}
	public Shares(int quantity, String companyName, LocalDate buyDate, LocalDate sellDate, float price) {
		super();
		this.quantity = quantity;
		this.companyName = companyName;
		this.buyDate = buyDate;
		this.sellDate = sellDate;
		this.price = price;
	}
	public Shares(long id, int quantity, String companyName, LocalDate buyDate, LocalDate sellDate, float price) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.companyName = companyName;
		this.buyDate = buyDate;
		this.sellDate = sellDate;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Shares [id=" + id + ", quantity=" + quantity + ", companyName=" + companyName + ", buyDate=" + buyDate
				+ ", sellDate=" + sellDate + ", price=" + price + "]";
	}

}
