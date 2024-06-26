package edu.fbansept.demo.controller;

import edu.fbansept.demo.security.AppUserDetails;
import edu.fbansept.demo.security.IsAdmin;
import edu.fbansept.demo.security.IsUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "<h1>Hello anonyme</h1>";
    }

    @IsUser
    @GetMapping("/hello-user")
    public String helloUser(
            @AuthenticationPrincipal AppUserDetails userDetails) {
        return "<h1>Hello " + userDetails.getUtilisateur().getId() + "</h1>";
    }

    @IsAdmin
    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "<h1>Hello admin</h1>";
    }

}
