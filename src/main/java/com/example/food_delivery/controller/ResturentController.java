
package com.example.food_delivery.controller;
import com.example.food_delivery.entities.menu;
import com.example.food_delivery.entities.resturent;
import com.example.food_delivery.services.MenuService;
import com.example.food_delivery.services.ResturentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restAuth")
public class ResturentController {

    private final ResturentService resturentService;
    private final MenuService menuService;

    public ResturentController(ResturentService resturentService, MenuService menuService) {
        this.resturentService = resturentService;
        this.menuService = menuService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody resturent res) {
        System.out.println("sdkajdahnk" );
        return resturentService.register(res);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        String message = resturentService.login(username, password);

        // Store user information in the session
        session.setAttribute("username", username);


        if ("Login successful!".equals(message)) {

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
    public menu getSessionData(HttpSession session) {
        String username = (String) session.getAttribute("username");
        menu men    = menuService.getmenuByUsername(username);
        session.setAttribute("rst", men.getRst());
        String rst = (String) session.getAttribute("rst");
        men.setName(username);
        men.setRst(rst);
        return men;
    }
}
