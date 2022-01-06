package com.cg.zerodhaclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.zerodhaclone.entities.Shares;
import com.cg.zerodhaclone.service.ISharesService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
public class ShareController {

	@Autowired
	private ISharesService shareService;
	
	@PostMapping("/add")
	public ResponseEntity<Shares> addNewShares(@RequestBody Shares shares){
		Shares addNew = shareService.addNewShares(shares);
		return new ResponseEntity<Shares>(addNew,HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Shares>> listAllShares(){
		return new ResponseEntity<List<Shares>>(shareService.listAllShares(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Shares> getShareById(@PathVariable long id){
		return new ResponseEntity<Shares>(shareService.getShareById(id),HttpStatus.OK);
	}
	
	@PatchMapping("{traderId}")
	public ResponseEntity<Shares> attachTrader(@PathVariable long traderId,
			@RequestBody Shares share){
		return new ResponseEntity<Shares>(shareService.attachTrader(traderId, share),
				HttpStatus.OK);
	}
}
