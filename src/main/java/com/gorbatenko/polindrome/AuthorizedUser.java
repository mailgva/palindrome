package com.gorbatenko.polindrome;

import com.gorbatenko.polindrome.model.User;
import lombok.Data;

@Data
public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRoles());
    }

    @Override
    public String toString() {
        return user.toString();
    }
}