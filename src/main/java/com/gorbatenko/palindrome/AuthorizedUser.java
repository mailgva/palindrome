package com.gorbatenko.palindrome;

import com.gorbatenko.palindrome.model.User;
import com.gorbatenko.palindrome.util.UserUtil;
import lombok.Data;

@Data
public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), true, true, true, true, user.getRoles());
        this.user = user;
    }

    @Override
    public String toString() {
        return user.toString();
    }
}