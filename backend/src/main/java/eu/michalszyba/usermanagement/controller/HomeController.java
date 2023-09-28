package eu.michalszyba.usermanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping({"/", "/home"})
    public String home() {
        return "No authorization Test";
    }

    @GetMapping({"/home2"})
    public String home2() {
        return "authorization Test HOME2";
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
