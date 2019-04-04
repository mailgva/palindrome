package com.gorbatenko.polindrome;

import com.gorbatenko.polindrome.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Throwable {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        /*UserRepository userRepository = ctx.getBean(UserRepository.class);
        userRepository.findAll().forEach(System.out::println);*/
    }

}
