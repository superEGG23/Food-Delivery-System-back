package com.example.food_delivery.services;

import com.example.food_delivery.entities.menu;
import com.example.food_delivery.repositories.menuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final menuRepository menurepository;

    public MenuService(menuRepository menurepository) {
        this.menurepository = menurepository;
    }

    public List<menu> getAllmenus() {
        return menurepository.findAll();
    }

    public Optional<menu> getmenuById(Long id) {
        return menurepository.findById(id);
    }

    public menu addmenu(menu men) {
        return menurepository.save(men);
    }

    public menu updatemenu(menu men) {
        return menurepository.save(men);
    }

    public void deletemenu(Long id) {
        menurepository.deleteById(id);
    }

    public menu getmenuByUsername(String name) {
        return menurepository.findByname(name)
                .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + name));
    }
}
