package com.example.food_delivery.controller;

import com.example.food_delivery.entities.orders;
import com.example.food_delivery.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody orders order) {
        ordersService.saveOrder(order);
        return ResponseEntity.ok("Order placed successfully!");
    }
}
