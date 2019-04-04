package com.gorbatenko.polindrome.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class WebController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public String test(Principal principal, HttpServletRequest request) {
        logger.info("This is test page: " +  SecurityUtil.authUserName());
        return "test";
    }



}
