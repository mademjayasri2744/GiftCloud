package com.giftydelivery.service;

import com.giftydelivery.model.Order;
import com.giftydelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getPendingOrdersToDeliver() {
        return orderRepository.findByStatusAndScheduledTimeBefore("PENDING", LocalDateTime.now());
    }

    public void markOrderDelivered(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus("DELIVERED");
            orderRepository.save(order);
        }
    }
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
