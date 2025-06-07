package com.example.TenderManagementApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TenderManagementApplication.model.BiddingModel;


@Repository
public interface BiddingRepository extends JpaRepository<BiddingModel, Integer>{

	public List<BiddingModel> findByBidAmountGreaterThan(double bidAmount);
}
