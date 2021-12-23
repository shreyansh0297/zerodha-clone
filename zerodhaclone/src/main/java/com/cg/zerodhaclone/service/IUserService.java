package com.cg.zerodhaclone.service;

import org.springframework.stereotype.Service;

import com.cg.zerodhaclone.entities.User;

@Service
public interface IUserService {

	public User addNewUser(User user);
	public User getUserEmail(String emailId);
	public User signIn(String emailId,String password);
	public User signOut(String emailId,String password);
	public User getUserById(Long id);
}
