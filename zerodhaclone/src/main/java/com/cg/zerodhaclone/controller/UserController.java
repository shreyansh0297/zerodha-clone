package com.cg.zerodhaclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.zerodhaclone.entities.User;
import com.cg.zerodhaclone.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User newUser){
		
		User user = userService.getUserEmail(newUser.getEmailId());
		return new ResponseEntity<User>(userService.addNewUser(newUser), 
				HttpStatus.CREATED);
	}
	
	@GetMapping("/login")
	public ResponseEntity<User> signIn(@RequestBody User user){
		User userExists = userService.signIn(user.getEmailId(), user.getPassword());
		return new ResponseEntity<User>(userExists, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<User> signOut(@RequestBody User user){
		User userInSystem = userService.signOut(user.getEmailId(), user.getPassword());
		return new ResponseEntity<User>(userInSystem, HttpStatus.OK);
	}
	
}
