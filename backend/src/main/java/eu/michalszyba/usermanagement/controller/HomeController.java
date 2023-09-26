package eu.michalszyba.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "No authorization Test";
    }

    @GetMapping({"/api/admin/home"})
    public String homeAdmin() {
        return "Admin Test";
    }

    @GetMapping({"/api/user/home"})
    public String homeUser() {
        return "User test";
    }
    @GetMapping({"/logout"})
    public String logout() {
        return "Logout";
    }
}
