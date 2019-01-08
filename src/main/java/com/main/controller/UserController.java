package com.main.controller;

import com.main.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login-form";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser() {
        return "user-form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Validated User user) {
        return "list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser() {
        return "user-form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Validated User user) {

        return "list";
    }
}
