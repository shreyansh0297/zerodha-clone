package com.cg.zerodhaclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.zerodhaclone.entities.Admin;
import com.cg.zerodhaclone.entities.Role;
import com.cg.zerodhaclone.entities.Trader;
import com.cg.zerodhaclone.entities.User;
import com.cg.zerodhaclone.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	public User getUserEmail(String emailId) {
		
		return userRepo.findByEmailId(emailId);
	}

	@Override
	public User signIn(String emailId, String password) {
		
		return userRepo.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public User signOut(String emailId, String password) {
		
		return userRepo.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepo.getById(id);
	}

}
