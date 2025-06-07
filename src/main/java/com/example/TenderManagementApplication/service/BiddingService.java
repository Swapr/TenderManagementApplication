package com.example.TenderManagementApplication.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.TenderManagementApplication.model.BiddingModel;
import com.example.TenderManagementApplication.model.UserModel;
import com.example.TenderManagementApplication.repository.BiddingRepository;

@Service
public class BiddingService {
	
	
	@Autowired
	private BiddingRepository biddingRepository;
	
	@Autowired
	private UserService userService;
	
	
	public ResponseEntity<BiddingModel> postBidding(BiddingModel biddingModel){
		biddingModel.setDateOfBidding(gettime());
		biddingModel.setBidderId(getCurrentUserId());
		BiddingModel biddingModel2 = biddingRepository.save(biddingModel);
		if(biddingModel2 !=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(biddingModel2);
		}
		else
			return ResponseEntity.badRequest().body(null);
	}
	
	public ResponseEntity<Object> getBidding(double bidAmount){
		List<BiddingModel> list = biddingRepository.findByBidAmountGreaterThan(bidAmount);
		if(!list.isEmpty()) {
			return ResponseEntity.ok().body(list);
		}else
		{
			return ResponseEntity.badRequest().body("no data available");
		}
	
	}
	
	public ResponseEntity<Object> updateBidding(int id, BiddingModel biddingModel){
		Optional<BiddingModel> optional = biddingRepository.findById(id);
		if(optional.isPresent()) {
			BiddingModel biddingModel2 = optional.get();
			biddingModel2.setStatus(biddingModel.getStatus());
			BiddingModel biddingModel3 = biddingRepository.save(biddingModel2);
			return ResponseEntity.ok().body(biddingModel3);
		}else
		{
			return ResponseEntity.badRequest().body(null);
		}
	
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
    
    public int getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String UserName = userDetails.getUsername();
        UserModel userModel  = userService.getUserByEmail(UserName);
        return userModel.getId();
        
    }

}
