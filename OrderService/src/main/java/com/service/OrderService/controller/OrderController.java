package com.service.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.OrderService.model.Order;
import com.service.OrderService.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
    	return orderRepository.save(order);
    }
    
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
    	System.out.println("In Controller");
    	return new Order(id, "Laptop");
    }
}
