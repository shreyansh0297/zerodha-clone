package com.cg.zerodhaclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.zerodhaclone.entities.Trader;
import com.cg.zerodhaclone.service.ITraderService;

@RestController
@RequestMapping("/trader")
public class TraderController {

	@Autowired
	private ITraderService traderService;
	
	@PatchMapping("/update")
	public ResponseEntity<Trader> updateTrader(@RequestBody Trader trader){
		return new ResponseEntity<Trader>(traderService.addTrader(trader),HttpStatus.OK);
	}
	
	
	@PostMapping("{shareId}")
	public ResponseEntity<Trader> buyShare(@PathVariable long shareId,
			@RequestBody Trader trader){
		
		return new ResponseEntity<Trader>(traderService.buyShare(shareId,trader), 
				HttpStatus.CREATED);
	}
}
