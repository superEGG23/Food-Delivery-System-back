
package com.example.food_delivery.repositories;
import com.example.food_delivery.entities.menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface menuRepository extends JpaRepository<menu, Long> {
    Optional<menu> findByname(String name);
}