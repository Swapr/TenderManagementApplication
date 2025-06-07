package com.example.TenderManagementApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TenderManagementApplication.model.BiddingModel;
import com.example.TenderManagementApplication.service.BiddingService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearerAuth")
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
	@PreAuthorize("hasRole('APPROVER')")
	public ResponseEntity<Object> updateBidding(@PathVariable int id,@RequestBody BiddingModel biddingModel){
	return 	biddingService.updateBidding(id, biddingModel);
		
	}
	
	@DeleteMapping("/delete/{id}")
	//@PreAuthorize("hasRole('BIDDER') or hasRole('APPROVER')")
	public ResponseEntity<Object> deleteBidding(@PathVariable Integer id){
		return biddingService.deleteBidding(id);
	}
	
	
}
