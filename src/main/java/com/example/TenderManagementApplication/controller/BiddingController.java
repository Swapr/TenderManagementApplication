package com.example.TenderManagementApplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TenderManagementApplication.model.BiddingModel;

@Controller
@RequestMapping("/bidding")
public class BiddingController {

	
	@PostMapping("/add")
	public ResponseEntity<Object> postBidding( BiddingModel biddingModel){
		return null;
	}
	
	@PostMapping("/list")
	public ResponseEntity<Object> getBidding(Double bidAmount){
		return null;
	}
	
	@PostMapping("/update{id}")
	public ResponseEntity<Object> updateBidding(int id,BiddingModel biddingModel){
		return null;
	}
	
	@DeleteMapping("/delete{id}")
	public ResponseEntity<Object> deleteBidding(int id){
		return null;
	}
	
}
