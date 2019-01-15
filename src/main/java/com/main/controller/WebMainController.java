package com.main.controller;

import com.main.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebMainController {

    @RequestMapping(value = "/")
    public String index() {return "home";}

    @RequestMapping(value = "/home")
    public String home() {return "home";}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() { return "login"; }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin() { return "list"; }

    @RequestMapping(value = "/list")
    public String list() { return "list"; }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String addUser() { return "form"; }




}
