package com.marketplace.dev.service;

import com.marketplace.dev.entity.Address;
import com.marketplace.dev.repository.AddressRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(final Address address){
        LOGGER.info("Creating address with id: " + address.getAddressID());

        addressRepository.save(address);
    }

    public List<Address> findAllAddresses(){
        LOGGER.info("Retrieving all addresses...");

        final List<Address> addresses = new ArrayList<Address>();
        addressRepository.findAll().forEach(address -> addresses.add(address));

        return addresses;
    }

    public Address findAddress(final int id){
        LOGGER.info("Searching for address with id: " + id);

        Optional<Address> address = addressRepository.findById(id);

        if(address.isPresent()){
            return address.get();
        }
        else
        {
            throw new RuntimeException("ERROR: Could no find address with id: " + id);
        }
    }

    public void updateAddress(final Address address){
        LOGGER.info("Updating address with id: " + address.getAddressID());
        addressRepository.save(address);
    }

    public void deleteAddress(final int id){
        LOGGER.info("Deleting address with id " + id);
        addressRepository.deleteById(id);
    }
}
