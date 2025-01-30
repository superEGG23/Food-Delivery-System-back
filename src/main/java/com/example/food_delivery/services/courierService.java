
package com.example.food_delivery.services;
import com.example.food_delivery.entities.courier;
import com.example.food_delivery.repositories.courierRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class courierService {

    private final courierRepository courierrepository;

    public courierService(courierRepository courierrepository) {
        this.courierrepository = courierrepository;
    }



    public String register(courier cr) {

        Optional<courier> existingUser = courierrepository.findByUsername(cr.getUsername());
        if (existingUser.isPresent()) {
            System.out.println("User already exists");
            return "Username already exists!";
        }


        cr.setLocation("Courier");
        courierrepository.save(cr);
        System.out.println("crier registered successfully!");
        System.out.println("succkees registered!");
        return "crier registered successfully!";
    }

    public String login(String username, String password) {
        // Validate username and password
        Optional<courier> cr = courierrepository.findByUsername(username);
        if (cr.isPresent() && cr.get().getPassword().equals(password)) {
            return "Login successful!";
        }
        System.out.println("Invalid username or password!");
        return "Invalid username or password!";
    }
}
