package com.cg.zerodhaclone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.zerodhaclone.entities.Shares;

@Service
public interface ISharesService {

	public Shares addNewShares(Shares shares);
	public Shares getShareById(long id);
	public List<Shares> listAllShares();
	public Shares attachTrader(long traderId, Shares share);
}
