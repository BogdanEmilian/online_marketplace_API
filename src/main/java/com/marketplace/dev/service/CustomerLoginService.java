package com.marketplace.dev.service;

import com.marketplace.dev.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLoginService {
    
    @Autowired
    private CustomerRepository customerRepository;

    //TODO: save authentication data of customers on login with google account
}
