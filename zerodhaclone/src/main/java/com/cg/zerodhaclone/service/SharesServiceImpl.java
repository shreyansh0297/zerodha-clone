package com.cg.zerodhaclone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.zerodhaclone.entities.Shares;
import com.cg.zerodhaclone.repository.ISharesRepository;

@Service
public class SharesServiceImpl implements ISharesService{

	@Autowired
	ISharesRepository shareRepo;
	
	@Override
	public Shares addNewShares(Shares shares) {
		
		return shareRepo.save(shares);
	}

	@Override
	public Shares getShareById(long id) {
		
		return shareRepo.findById(id).get();
	}

	@Override
	public List<Shares> listAllShares() {
		return shareRepo.findAll();
	}

}
