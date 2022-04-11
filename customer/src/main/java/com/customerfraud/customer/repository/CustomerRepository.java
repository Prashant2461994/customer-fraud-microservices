package com.customerfraud.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customerfraud.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
