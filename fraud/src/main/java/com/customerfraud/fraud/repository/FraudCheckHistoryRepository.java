package com.customerfraud.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerfraud.fraud.model.FraudCheckHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
