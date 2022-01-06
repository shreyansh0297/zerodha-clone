package com.cg.zerodhaclone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.zerodhaclone.entities.Shares;
import com.cg.zerodhaclone.entities.Trader;
import com.cg.zerodhaclone.repository.ISharesRepository;
import com.cg.zerodhaclone.repository.ITraderRepository;

@Service
public class SharesServiceImpl implements ISharesService{

	@Autowired
	private ISharesRepository shareRepo;
	
	@Autowired
	private ITraderRepository traderRepo;
	
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

	@Override
	public Shares attachTrader(long traderId, Shares share) {
		Shares existingShare = shareRepo.findById(share.getId()).get();
		Trader trader = traderRepo.findById(traderId).get();
		existingShare.setTrader(trader);
		return shareRepo.save(existingShare);
	}

}
