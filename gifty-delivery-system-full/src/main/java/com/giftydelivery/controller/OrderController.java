package com.giftydelivery.controller;

import com.giftydelivery.model.Order;
import com.giftydelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    @PutMapping("/deliver/{orderId}")
    public String deliverOrder(@PathVariable Long orderId) {
        orderService.markOrderDelivered(orderId);
        return "Order marked as DELIVERED";
    }
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order deleted successfully";
    }

}
