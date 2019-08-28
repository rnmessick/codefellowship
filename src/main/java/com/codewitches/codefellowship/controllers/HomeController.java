package com.codewitches.codefellowship.controllers;

import com.codewitches.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @GetMapping("/")
    public String getRoot(Principal p, Model m) {
        if(p != null) {
            m.addAttribute("viewedUser", applicationUserRepository.findByUsername(p.getName()));
            m.addAttribute("user", p);
        }
        else {
            m.addAttribute("viewedUser", null);
            m.addAttribute("user", null);
        }
            return "root";

    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getSignup() {
        return "register";
    }
}