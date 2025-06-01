package com.example.TenderManagementApplication.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.TenderManagementApplication.model.BiddingModel;
import com.example.TenderManagementApplication.repository.BiddingRepository;

import io.jsonwebtoken.lang.Objects;

@Service
public class BiddingService {
	
	
	@Autowired
	private BiddingRepository biddingRepository;
	
	
	public ResponseEntity<BiddingModel> postBidding(BiddingModel biddingModel){
		biddingModel.setDateOfBidding(gettime());
		BiddingModel biddingModel2 = biddingRepository.save(biddingModel);
		if(biddingModel2 !=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(biddingModel2);
		}
		else
			return ResponseEntity.badRequest().body(null);
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
    public String gettime() {
        long milliseconds = System.currentTimeMillis();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return formatter.format(calendar.getTime());
    }

}
