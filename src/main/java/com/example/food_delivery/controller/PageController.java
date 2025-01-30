package com.example.food_delivery.controller;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "user_login";
    }

    @GetMapping("/restulogin")
    public String restlogin() {
        return "resturent_login";
    }

    @GetMapping("/restureg")
    public String restreg() {
        return "resturent_signup";
    }

    @GetMapping("/signup")
    public String register() {
        return "user_signup";
    }
    @GetMapping("/gs")
    public String gs() {
        return "getstarted";
    }

    @GetMapping("/browsmenus")
    public String brows() {
        return "brows";
    }
    @GetMapping("/hoteldash")
    public String hd(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";  // Redirect to login if no user is logged in
        }
        return "hoteldash";
    }
    @GetMapping("/welcome")
    public String ud(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";  // Redirect to login if no user is logged in
        }

        return "UserDash";
    }
    @GetMapping("/courierdash")
    public String cd(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";  // Redirect to login if no user is logged in
        }
        return "courierdash";
    }

}
