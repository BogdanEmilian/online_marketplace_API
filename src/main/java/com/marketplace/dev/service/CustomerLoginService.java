package com.marketplace.dev.service;

import com.marketplace.dev.entity.Customer;
import com.marketplace.dev.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerLoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLoginService.class);

    @Autowired
    private CustomerRepository customerRepository;

    //TODO: save authentication data of customers on login with google account

    public void saveCustomer(final Customer customer){
        LOGGER.info("Creating customer with name: " + customer.getCustomerName());

        customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers(){
        LOGGER.info("Retrieving all customers...");

        final List<Customer> customers = new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customers.add(customer));

        return customers;
    }


}
