package com.example.food_delivery.services;

import com.example.food_delivery.entities.orders;
import com.example.food_delivery.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void saveOrder(orders order) {
        ordersRepository.save(order);
    }
}
