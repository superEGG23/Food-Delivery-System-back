package com.example.food_delivery.controller;

import com.example.food_delivery.entities.User;
import com.example.food_delivery.services.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        System.out.println("User registered successfully!");
        return authService.register(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        String message = authService.login(username, password);

        if ("Login successful!".equals(message)) {
            session.setAttribute("username", username);
            User user    = authService.getUserByUsername(username);
            session.setAttribute("address", user.getAddress());
            return "Login successful!";
        } else {
            return "Invalid username or password!";
        }
    }

    @PostMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "Logged out successfully!";
    }
    @GetMapping("/session")
    public User  getSessionData(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String address = (String) session.getAttribute("address");
        User user = new User();
        user.setUsername(username);
        user.setAddress(address);
        return user;
    }

}
