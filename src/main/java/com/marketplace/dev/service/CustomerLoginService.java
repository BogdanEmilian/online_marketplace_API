package com.marketplace.dev.service;

import com.marketplace.dev.entity.Customer;
import com.marketplace.dev.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerLoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerLoginService.class);

    @Autowired
    private CustomerRepository customerRepository;

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

    public Customer findCustomer(final int id){
        LOGGER.info("Searching for customer with id: " + id);

        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            return customer.get();
        }
        else
        {
            throw new RuntimeException("ERROR: Could no find customer with id: " + id);
        }
    }

    public void updateCustomer(final Customer customer){
        LOGGER.info("Updating customer with id: " + customer.getCustomerID());
        customerRepository.save(customer);
    }

    public void deleteCustomer(final int id){
        LOGGER.info("Deleting customer with id " + id);
        customerRepository.deleteById(id);
    }
}
