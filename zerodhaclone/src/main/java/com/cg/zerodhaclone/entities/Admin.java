package com.cg.zerodhaclone.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin_tbl")
public class Admin extends User{

	public Admin() {
		super();
		
	}

	public Admin(String name, LocalDate dateOfBirth, String emailId, String password, String phoneNumber, Role role) {
		super(name, dateOfBirth, emailId, password, phoneNumber, role);
		
	}

	public Admin(long id, String name, LocalDate dateOfBirth, String emailId, String password, String phoneNumber,
			Role role) {
		super(id, name, dateOfBirth, emailId, password, phoneNumber, role);
		
	}

	

	
}
