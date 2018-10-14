package com.hqzmss.controller;

import com.hqzmss.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {
    private User user;

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(User user) {
        this.user = user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public User get() {
        return this.user;
    }
}
