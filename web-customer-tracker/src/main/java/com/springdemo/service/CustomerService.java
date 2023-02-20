package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.repository.CustomerRepository;
import com.springdemo.model.Customer;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findByOrderByLastNameAsc();
    }

    public Customer getCustomer(int theId) {
        return customerRepository.getReferenceById(theId);
    }

    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }
}
