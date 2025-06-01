package com.example.TenderManagementApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class BiddingModel {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private int biddingId;
	private String projectName = "Metro Phase V 2024";
	private Double bidAmount ;
	private Double yearsToComplete;
	private String dateOfBidding;
	private String status = "pending";
	private int bidderId;
	public BiddingModel() {
		super();
	}
	public BiddingModel(int id, int biddingId, String projectName, Double bidAmount, Double yearsToComplete,
			String dateOfBidding, String status, int bidderId) {
		super();
		this.id = id;
		this.biddingId = biddingId;
		this.projectName = projectName;
		this.bidAmount = bidAmount;
		this.yearsToComplete = yearsToComplete;
		this.dateOfBidding = dateOfBidding;
		this.status = status;
		this.bidderId = bidderId;
	}
	public BiddingModel(int biddingId, Double bidAmount, Double yearsToComplete) {
		super();
		this.biddingId = biddingId;
		this.bidAmount = bidAmount;
		this.yearsToComplete = yearsToComplete;
	}
	public BiddingModel(String status) {
		super();
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBiddingId() {
		return biddingId;
	}
	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public Double getYearsToComplete() {
		return yearsToComplete;
	}
	public void setYearsToComplete(Double yearsToComplete) {
		this.yearsToComplete = yearsToComplete;
	}
	public String getDateOfBidding() {
		return dateOfBidding;
	}
	public void setDateOfBidding(String dateOfBidding) {
		this.dateOfBidding = dateOfBidding;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	
	

}
