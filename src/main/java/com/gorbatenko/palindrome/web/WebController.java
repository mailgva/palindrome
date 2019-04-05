package com.gorbatenko.palindrome.web;

import com.gorbatenko.palindrome.model.Role;
import com.gorbatenko.palindrome.model.User;
import com.gorbatenko.palindrome.repository.UserRepository;
import com.gorbatenko.palindrome.service.UserService;
import com.gorbatenko.palindrome.service.UserServiceImpl;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;

@Controller
public class WebController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String index() {
        return "redirect:app";
    }

    @GetMapping("/app")
    public String app() {
        return "app";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String newUser(@RequestBody User user) {
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        repository.save(user);
        return "redirect:app";
    }


}
