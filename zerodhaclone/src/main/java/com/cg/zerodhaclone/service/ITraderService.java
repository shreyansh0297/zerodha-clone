package com.cg.zerodhaclone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.zerodhaclone.entities.Shares;
import com.cg.zerodhaclone.entities.Trader;

@Service
public interface ITraderService {


	public Trader buyShare(long shareId,Trader trader);
	public Trader sellShare(long shareId,Trader trader);
	public Trader addTrader(Trader trader);
}
