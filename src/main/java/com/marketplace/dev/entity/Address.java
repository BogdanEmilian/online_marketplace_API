package com.marketplace.dev.entity;

import jakarta.persistence.*;

//TODO: check if creating a table in the database for the addresses is okay
// What would be an alternative or appropriate approach
@Entity
@Table(name="addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressID;

    private String addressLocation;
    private String addressPhone;
    private String addressName;

    public Address(){

    }

    public Address(String addressLocation, String addressPhone, String addressName){
        this.addressLocation = addressLocation;
        this.addressPhone = addressPhone;
        this.addressName = addressName;
    }

    public int getAddressID() {
        return addressID;
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
