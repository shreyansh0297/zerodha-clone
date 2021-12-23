package com.cg.zerodhaclone.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_zc")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

	@Id
	@SequenceGenerator(name = "UIdGeneration",
	sequenceName = "userSequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "UIdGeneration")
	private long id;
	
	private String name;
	private LocalDate dateOfBirth;
	private String emailId;
	private String password;
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User() {
		super();
	}
	public User(String name, LocalDate dateOfBirth, String emailId, String password, String phoneNumber, Role role) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}
	public User(long id, String name, LocalDate dateOfBirth, String emailId, String password, String phoneNumber,
			Role role) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", role=" + role + "]";
	}
		
}
