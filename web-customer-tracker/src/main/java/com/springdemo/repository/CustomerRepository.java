package com.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdemo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByOrderByLastNameAsc();

}
