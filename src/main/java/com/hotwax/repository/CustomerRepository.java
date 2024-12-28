package com.hotwax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotwax.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
