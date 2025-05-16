package com.example.ss09.controller;

import com.example.ss09.model.Customer;
import com.example.ss09.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("login")
    public String handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        Customer customer = loginService.login(username, password);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "redirect:/home?customerId=" + customer.getId();
        } else {
            return "login";
        }
    }

}
