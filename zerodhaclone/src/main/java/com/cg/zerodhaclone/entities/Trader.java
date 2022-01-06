package com.cg.zerodhaclone.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "trader_tbl")
public class Trader extends User{

	private double balance;
	@OneToMany(mappedBy = "trader",
			fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	private List<Shares> shares;
	private String panCard;
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Shares> getShares() {
		return shares;
	}
	public void setShares(List<Shares> shares) {
		this.shares = shares;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public Trader(double balance, List<Shares> shares, String panCard) {
		super();
		this.balance = balance;
		this.shares = shares;
		this.panCard = panCard;
	}
	public Trader() {
		super();
		
	}
	public Trader(String name, LocalDate dateOfBirth, String emailId, String password, String phoneNumber, Role role) {
		super(name, dateOfBirth, emailId, password, phoneNumber, role);
		
	}
	
	public Trader(long id, String name, LocalDate dateOfBirth, String emailId, String password, String phoneNumber,
			Role role) {
		super(id, name, dateOfBirth, emailId, password, phoneNumber, role);
		
	}
	@Override
	public String toString() {
		return "Trader [balance=" + balance + ", shares=" + shares + ", panCard=" + panCard + "]";
	}
	
}
