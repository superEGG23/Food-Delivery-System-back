package com.example.food_delivery.controller;

import com.example.food_delivery.entities.courier;
import com.example.food_delivery.services.courierService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courierAuth")
public class CourierController {

    private final courierService courierservice;

    public CourierController(courierService courierservice) {
        this.courierservice = courierservice;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody courier cr) {
        System.out.println("sdkajdahnk" );
        return courierservice.register(cr);
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        String message = courierservice.login(username, password);

        if ("Login successful!".equals(message)) {
            // Store user information in the session
            session.setAttribute("username", username);

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
    public String getSessionData(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return username != null ? username : "Guest";
    }
}



