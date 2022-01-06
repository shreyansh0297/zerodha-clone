package com.cg.zerodhaclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.zerodhaclone.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	public User findByEmailIdAndPassword(String emailId,String password);
	public User findByEmailId(String emailId);
}
