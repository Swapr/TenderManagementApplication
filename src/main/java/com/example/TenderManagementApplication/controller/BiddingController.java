package com.example.TenderManagementApplication.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TenderManagementApplication.model.BiddingModel;
import com.example.TenderManagementApplication.service.BiddingService;

@Controller
@RequestMapping("/bidding")
public class BiddingController {
	
	@Autowired
	private BiddingService biddingService;

	
	@PostMapping("/add")
	@PreAuthorize("hasRole('BIDDER')")
	public ResponseEntity<BiddingModel> postBidding(@RequestBody BiddingModel biddingModel){
		System.out.println("reuquest recevied to add bidding ");
		return biddingService.postBidding(biddingModel);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> getBidding(@RequestParam Double bidAmount){
		
		return biddingService.getBidding(bidAmount);
		
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Object> updateBidding(@PathVariable int id,@RequestBody BiddingModel biddingModel){
		biddingService.updateBidding(id, biddingModel);
		return null;
	}
	
	@DeleteMapping("/delete{id}")
	public ResponseEntity<Object> deleteBidding(int id){
		return null;
	}
	
	
}
