package com.codewitches.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getRoot(Principal p, Model m) {
        m.addAttribute("user", p);
        return "root";
    }

    @GetMapping("/register")
    public String getSignup() {
        return "register";
    }
}