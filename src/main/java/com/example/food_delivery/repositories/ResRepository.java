
package com.example.food_delivery.repositories;
import com.example.food_delivery.entities.resturent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResRepository extends JpaRepository<resturent, Long> {
    Optional<resturent> findByUsername(String username);
}