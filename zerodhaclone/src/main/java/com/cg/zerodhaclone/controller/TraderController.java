package com.cg.zerodhaclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.zerodhaclone.entities.Trader;
import com.cg.zerodhaclone.exception.EmailAlreadyExistsException;
import com.cg.zerodhaclone.service.ITraderService;

@RestController
@RequestMapping("/trader")
public class TraderController {

	@Autowired
	private ITraderService traderService;
	
	@PatchMapping("/update/{traderId}")
	public ResponseEntity<Trader> updateTrader(@PathVariable long traderId,@RequestBody Trader trader){
		return new ResponseEntity<Trader>(traderService.updateTrader(traderId,trader),
				HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Trader> addTrader(@RequestBody Trader newTrader) throws EmailAlreadyExistsException{
		Trader trader = traderService.getByEmailId(newTrader.getEmailId());
		if (trader != null) {
			throw new EmailAlreadyExistsException(
					"Email already exists ! "
					+ "Try to login or register with a different email id");
		}
		return new ResponseEntity<Trader>(traderService.addTrader(trader),HttpStatus.CREATED);
	}
	
	@PatchMapping("{shareId}")
	public ResponseEntity<Trader> buyShare(@PathVariable long shareId,
			@RequestBody Trader trader){
		
		return new ResponseEntity<Trader>(traderService.buyShare(shareId,trader), 
				HttpStatus.OK);
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<Trader>> listAll(){
		return new ResponseEntity<List<Trader>>(traderService.getAllTraders(),HttpStatus.OK);
	}
}
