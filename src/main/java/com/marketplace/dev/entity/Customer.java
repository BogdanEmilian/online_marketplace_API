package com.marketplace.dev.entity;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    private String customerEmail;
    private String customerName;
    private String customerGoogleID;




}
