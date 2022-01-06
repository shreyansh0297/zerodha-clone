package com.cg.zerodhaclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.zerodhaclone.entities.User;
import com.cg.zerodhaclone.exception.UserNotFoundException;
import com.cg.zerodhaclone.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/login/{emaild}/{password}")
	public ResponseEntity<User> signIn(@PathVariable String emailId,String password) throws UserNotFoundException{
		User userExists = userService.signIn(emailId,password);
		if (userExists != null) {
			return new ResponseEntity<User>(userExists, HttpStatus.OK);
		}
		throw new UserNotFoundException("User Not Found ! Try registering first...");
	}

	@GetMapping("/logout")
	public ResponseEntity<User> signOut(@RequestBody User user){
		User userInSystem = userService.signOut(user.getEmailId(), user.getPassword());
		return new ResponseEntity<User>(userInSystem, HttpStatus.OK);
	}

}
