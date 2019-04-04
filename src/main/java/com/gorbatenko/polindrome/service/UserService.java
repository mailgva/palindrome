package com.gorbatenko.polindrome.service;

import com.gorbatenko.polindrome.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

   /* User create(User user);

    void delete(int id);

    User get(int id);

    User getByEmail(String email);

    void update(User user);

    List<User> getAll();

    //User getWithHistory(int id);*/
}