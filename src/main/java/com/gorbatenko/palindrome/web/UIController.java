package com.gorbatenko.palindrome.web;

import com.gorbatenko.palindrome.model.History;
import com.gorbatenko.palindrome.model.User;
import com.gorbatenko.palindrome.repository.HistoryRepository;
import com.gorbatenko.palindrome.repository.UserRepository;
import com.gorbatenko.palindrome.to.ResultTo;
import com.gorbatenko.palindrome.util.PalindromUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/ajax")
public class UIController {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/value/{value}")
    public ResultTo getValue(@PathVariable("value") long value){
        if(SecurityUtil.safeGet() != null) {
            historyRepository.save(new History(userRepository.getByEmail(SecurityUtil.authUserName()), value));
        }

        String errorMessage      = "This that number [%d] is incorrect for search min/max palindroms.";
        String alreadyPalindrome = "This that number [%d] is already palindrome.";
        long min = 0;
        long max = 0;
        String dopInfo = "";
        if((value < 1)||(value >= Long.MAX_VALUE )) {
            dopInfo = String.format(errorMessage, value);
        } else {
            if(PalindromUtil.isPalindrome(value)) {
                dopInfo = String.format(alreadyPalindrome, value);
            } else {
                min = PalindromUtil.findMinValue(value);
                max = PalindromUtil.findMaxValue(value);
            }
        }

        return new ResultTo(value, min, max, dopInfo, getHistory());
    }

    @GetMapping("/history")
    public List<History> getHistory() {
        List<History> result = new ArrayList<>();

        if(SecurityUtil.safeGet() != null) {
            result = historyRepository.getByUserIdSOrderByDateTimeDesc(userRepository.getByEmail(SecurityUtil.authUserName()).getId());
        }
        return result;

    }

    @GetMapping("/user/{email}")
    public String getUser(@PathVariable("email") String email) {
        User user = userRepository.getByEmail(email);
        return (user != null ? "true" : "false");
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }


}
