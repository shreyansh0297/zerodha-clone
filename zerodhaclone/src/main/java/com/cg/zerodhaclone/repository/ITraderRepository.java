package com.cg.zerodhaclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.zerodhaclone.entities.Trader;

@Repository
public interface ITraderRepository extends JpaRepository<Trader, Long>{

	public Trader findByEmailId(String emailId);
}
