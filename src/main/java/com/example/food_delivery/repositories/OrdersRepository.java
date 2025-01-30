package com.example.food_delivery.repositories;

import com.example.food_delivery.entities.orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<orders, Long> {
}
