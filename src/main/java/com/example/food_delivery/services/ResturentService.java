
package com.example.food_delivery.services;
import org.springframework.stereotype.Service;
import com.example.food_delivery.entities.resturent;
import com.example.food_delivery.repositories.ResRepository;
import java.util.Optional;

@Service
public class ResturentService {

    private final ResRepository resrepo;

    public ResturentService(ResRepository resrepo) {
        this.resrepo = resrepo;
    }



    public String register(resturent res) {

        Optional<resturent> existingUser = resrepo.findByUsername(res.getUsername());
        if (existingUser.isPresent()) {
            System.out.println("User already exists");
            return "Username already exists!";
        }
        res.setAddress("default");
        res.setOpen("default");
        resrepo.save(res);
        System.out.println("resturent registered successfully!");
        return "resturent registered successfully!";
    }

    public String login(String username, String password) {
        Optional<resturent> res = resrepo.findByUsername(username);
        if (res.isPresent() && res.get().getPassword().equals(password)) {
            return "Login successful!";
        }
        System.out.println("Invalid username or password!");
        return "Invalid username or password!";
    }
}
