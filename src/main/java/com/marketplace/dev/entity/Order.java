package com.marketplace.dev.entity;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    private Calendar orderFulfillmentDate;
    private float orderTotalCost;

    @ManyToOne
    @JoinColumn(name = "addressID")
    private Address orderDeliveryAddress;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "orderID")
    private List<Item> orderItems;

    public Order(){

    }

    public Order(Calendar orderFulfillmentDate, float orderTotalCost, Address orderDeliveryAddress, List<Item> orderItems) {
        this.orderFulfillmentDate = orderFulfillmentDate;
        this.orderTotalCost = orderTotalCost;
        this.orderDeliveryAddress = orderDeliveryAddress;
        this.orderItems = orderItems;
    }

    public int getOrderID() {
        return orderID;
    }

    public Calendar getOrderFulfillmentDate() {
        return orderFulfillmentDate;
    }

    public float getOrderTotalCost() {
        return orderTotalCost;
    }

    public Address getOrderDeliveryAddress() {
        return orderDeliveryAddress;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderFulfillmentDate(Calendar orderFulfillmentDate) {
        this.orderFulfillmentDate = orderFulfillmentDate;
    }

    public void setOrderTotalCost(float orderTotalCost) {
        this.orderTotalCost = orderTotalCost;
    }

    public void setOrderDeliveryAddress(Address orderDeliveryAddress) {
        this.orderDeliveryAddress = orderDeliveryAddress;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }
}
