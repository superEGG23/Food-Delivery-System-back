package com.example.food_delivery.controller;

import com.example.food_delivery.entities.menu;
import com.example.food_delivery.services.MenuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping
    public ResponseEntity<?> getAllProducts(Model model, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in. Please log in first.");
        }
        List<menu> menu = menuService.getAllmenus();
        return ResponseEntity.ok(menu);
    }



    @PostMapping("/create")
    public String createProduct(@ModelAttribute menu men, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        menuService.addmenu(men);
        return "redirect:/welcome";
    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute menu men, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/welcome";
        }

        menuService.updatemenu(men);
        return "redirect:/welcome";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        menuService.deletemenu(id);
        return "redirect:/welcome";
    }
        @GetMapping("/{id}")
        public ResponseEntity<menu> getMenuById(@PathVariable Long id) {
            Optional<menu> menu = menuService.getmenuById(id);
            if (menu.isPresent()) {
                return ResponseEntity.ok(menu.get());
            } else {
                return ResponseEntity.notFound().build();
            }
    }
}
