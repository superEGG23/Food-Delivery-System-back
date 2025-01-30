package com.example.food_delivery.services;



import com.example.food_delivery.entities.User;
import com.example.food_delivery.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public String register(User user) {
        // Check if username already exists
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            System.out.println("User already exists");
            return "Username already exists!";
        }

        // Save the user
        user.setAddress("USER"); // Default role
        user.setRole("USER"); // Default role
        userRepository.save(user);
        System.out.println("User registered successfully!");
        System.out.println("succkees registered!");
        return "User registered successfully!";
    }

    public String login(String username, String password) {
        // Validate username and password
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "Login successful!";
        }
        System.out.println("Invalid username or password!");
        return "Invalid username or password!";
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));
    }
}
