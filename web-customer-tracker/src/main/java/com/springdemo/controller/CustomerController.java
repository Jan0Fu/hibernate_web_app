package com.springdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.model.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    public String homepage() {
        return "redirect:/customer/list";
    }

    @RequestMapping("/customer/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = customerService.allCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }
}
