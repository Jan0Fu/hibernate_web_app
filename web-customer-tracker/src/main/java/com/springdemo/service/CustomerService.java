package com.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.repository.CustomerRepository;
import com.springdemo.model.Customer;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> allCustomers() {
        Iterable<Customer> source = customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        source.forEach(customers::add);
        return customers;
    }
}
