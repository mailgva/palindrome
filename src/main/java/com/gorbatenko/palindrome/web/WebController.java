package com.gorbatenko.palindrome.web;

import com.gorbatenko.palindrome.model.Role;
import com.gorbatenko.palindrome.model.User;
import com.gorbatenko.palindrome.repository.UserRepository;
import com.gorbatenko.palindrome.service.UserService;
import com.gorbatenko.palindrome.service.UserServiceImpl;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class WebController {
    @Autowired
    private UserService userService;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String newUser(@ModelAttribute User user) {
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userService.create(user);
        return "redirect:app";
    }

    @ModelAttribute("userName")
    private String getUserName(){
        try {
            return  SecurityUtil.authUserName();
        } catch (Exception e) {
            return null;
        }
    }


}
