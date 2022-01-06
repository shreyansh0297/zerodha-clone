package com.cg.zerodhaclone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.zerodhaclone.entities.Shares;
import com.cg.zerodhaclone.entities.Trader;
import com.cg.zerodhaclone.entities.User;
import com.cg.zerodhaclone.repository.ISharesRepository;
import com.cg.zerodhaclone.repository.ITraderRepository;
import com.cg.zerodhaclone.repository.IUserRepository;

@Service
public class TraderServiceImpl implements ITraderService{

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private ISharesRepository shareRepo;
	
	@Autowired
	private ITraderRepository traderRepo;

	@Override
	public Trader buyShare(long shareId,Trader trader) {
		Trader existingTrader = traderRepo.findById(trader.getId()).get();
		List<Shares> listOfShares = shareRepo.findAll();
//		Shares share = shareRepo.findById(shareId).get();
		List<Shares> listOfShares2 = new ArrayList<>();
		
		for(Shares share:listOfShares) {
			if(share.getId() == shareId) {
				listOfShares2.add(share);
			}
		}
		existingTrader.setShares(listOfShares2);
		traderRepo.save(existingTrader);
		return existingTrader;
	}

	@Override
	public Trader sellShare(long shareId,Trader trader) {
		
		Trader existingTrader = traderRepo.findById(trader.getId()).get();
		List<Shares> listOfShares = shareRepo.findAll();
//		Shares share = shareRepo.findById(shareId).get();
		List<Shares> listOfShares2 = new ArrayList<>();
		
		for(Shares share:listOfShares) {
			if(share.getId() == shareId) {
				listOfShares2.remove(share);
			}
		}
		existingTrader.setShares(listOfShares2);
		traderRepo.save(existingTrader);
		return existingTrader;
	}

	@Override
	public Trader updateTrader(long traderId,Trader trader) {
		Trader existingTrader = traderRepo.findById(traderId).get();
		existingTrader.setBalance(trader.getBalance());
		existingTrader.setPanCard(trader.getPanCard());
		
		return traderRepo.save(existingTrader);
	}

	@Override
	public Trader addTrader(Trader trader) {
		return traderRepo.save(trader);
	}

	@Override
	public Trader getByEmailId(String emailId) {
		return traderRepo.findByEmailId(emailId);
	}

	@Override
	public List<Trader> getAllTraders() {
		return traderRepo.findAll();
	}
	
	
//	@Override
//	public Trader buyShare(long traderId, Shares share) {
//		Trader existingTrader = traderRepo.findById(traderId).get();
//		List<Shares> listOfShares = shareRepo.findAll();
////		Shares share = shareRepo.findById(shareId).get();
//		List<Shares> listOfShares2 = new ArrayList<>();
//		
//		
//		for(Shares share:listOfShares) {
//			if(share.getId() == shareId) {
//				listOfShares2.add(share);
//			}
//		}
//		existingTrader.setShares(listOfShares2);
//		traderRepo.save(existingTrader);
//		return existingTrader;
//	}

}
