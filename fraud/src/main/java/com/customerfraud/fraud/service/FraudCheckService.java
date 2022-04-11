package com.customerfraud.fraud.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerfraud.fraud.model.FraudCheckHistory;
import com.customerfraud.fraud.repository.FraudCheckHistoryRepository;

@Service
public class FraudCheckService {

	
	
	@Autowired
	FraudCheckHistoryRepository fraudCheckHistoryRepository;
	
	
	public boolean isFradulentCustomer(Integer customerId) {
		fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
				                         .customerId(customerId)
				                         .isFraudster(false)
				                         .createdAt(LocalDateTime.now())
				                         .build());
		return false;
		
	}
}
