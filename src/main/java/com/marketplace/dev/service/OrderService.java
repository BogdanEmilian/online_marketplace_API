package com.marketplace.dev.service;

import com.marketplace.dev.entity.Order;
import com.marketplace.dev.repository.OrderRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(final Order order){
        LOGGER.info("Creating order with id: " + order.getOrderID());

        orderRepository.save(order);
    }

    public List<Order> findAllOrders(){
        LOGGER.info("Retrieving all orders...");

        final List<Order> orders = new ArrayList<Order>();
        orderRepository.findAll().forEach(order -> orders.add(order));

        return orders;
    }

    public Order findOrder(final int id){
        LOGGER.info("Searching for order with id: " + id);

        Optional<Order> order = orderRepository.findById(id);

        if(order.isPresent()){
            return order.get();
        }
        else
        {
            throw new RuntimeException("ERROR: Could no find order with id: " + id);
        }
    }

    public void updateOrder(final Order order){
        LOGGER.info("Updating order with id: " + order.getOrderID());
        orderRepository.save(order);
    }

    public void deleteOrder(final int id){
        LOGGER.info("Deleting order with id " + id);
        orderRepository.deleteById(id);
    }
}
