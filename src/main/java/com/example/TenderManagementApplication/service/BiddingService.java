package com.example.TenderManagementApplication.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.TenderManagementApplication.model.BiddingModel;

@Service
public class BiddingService {
	
	
	
	public ResponseEntity<Object> postBidding(BiddingModel biddingModel){
		return null;
	}
	
	public ResponseEntity<Object> getBidding(double bidAmount){
		return null;
	}
	
	public ResponseEntity<Object> updateBidding(int id, BiddingModel biddingModel){
		return null;
	}
	
	public ResponseEntity<Object> deleteBidding(int id){
		return null;
	}

}
