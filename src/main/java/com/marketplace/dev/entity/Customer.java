package com.marketplace.dev.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;

    private String customerEmail;
    private String customerName;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "customerOrders")
    private List<Order> customerOrdersHistory = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "customerCart")
    private List<Item> customerCart = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "customerWishlist")
    private List<Item> customerWishlist = new ArrayList<>();

    public Customer(){

    }

    public Customer(String customerEmail, String customerName, List<Order> customerOrdersHistory, List<Item> customerCart, List<Item> customerWishlist) {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerOrdersHistory = customerOrdersHistory;
        this.customerCart = customerCart;
        this.customerWishlist = customerWishlist;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Order> getCustomerOrdersHistory() {
        return customerOrdersHistory;
    }

    public List<Item> getCustomerCart() {
        return customerCart;
    }

    public List<Item> getCustomerWishlist() {
        return customerWishlist;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerOrdersHistory(List<Order> customerOrdersHistory) {
        this.customerOrdersHistory = customerOrdersHistory;
    }

    public void setCustomerCart(List<Item> customerCart) {
        this.customerCart = customerCart;
    }

    public void setCustomerWishlist(List<Item> customerWishlist) {
        this.customerWishlist = customerWishlist;
    }
}
