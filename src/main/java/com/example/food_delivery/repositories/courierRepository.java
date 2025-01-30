package com.example.food_delivery.repositories;

import com.example.food_delivery.entities.courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface courierRepository extends JpaRepository<courier, Long> {
     Optional<courier> findByUsername(String username);
}