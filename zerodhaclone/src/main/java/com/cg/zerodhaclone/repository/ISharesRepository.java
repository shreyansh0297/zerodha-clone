package com.cg.zerodhaclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.zerodhaclone.entities.Shares;

@Repository
public interface ISharesRepository extends JpaRepository<Shares, Long>{

}
