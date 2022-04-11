package com.customerfraud.customer.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FraudCheckResponse {

	public FraudCheckResponse(Boolean isFraudster) {
		this.isFraudster = isFraudster;
	}

	private Boolean isFraudster;

	public Boolean getIsFraudster() {
		return isFraudster;
	}

	public void setIsFraudster(Boolean isFraudster) {
		this.isFraudster = isFraudster;
	}

}
