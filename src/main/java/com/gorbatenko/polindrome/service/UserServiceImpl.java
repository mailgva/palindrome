package com.gorbatenko.polindrome.service;

import com.gorbatenko.polindrome.AuthorizedUser;
import com.gorbatenko.polindrome.model.User;
import com.gorbatenko.polindrome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        System.out.println(user);
        return new AuthorizedUser(user);
    }
}
/*

@Service("userService")
public class UserServiceImpl implements UserService {


    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }



    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(prepareToSave(user, passwordEncoder));
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        repository.save(prepareToSave(user, passwordEncoder));
    }




    @Override
    public void delete(int id) {
        repository.delete(repository.getOne(id));
    }

    @Override
    public User get(int id) {
        return repository.getOne(id);
    }


    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }






    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        System.out.println(user);
        return new AuthorizedUser(user);
    }

    */
/*@Override
    public User getWithHistory(int id) {
        return repository.getWithHistory(id);
    }*//*

}*/
