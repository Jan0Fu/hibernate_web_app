package com.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdemo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
