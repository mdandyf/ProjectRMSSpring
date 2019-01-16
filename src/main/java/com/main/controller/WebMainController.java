package com.main.controller;

import com.main.form.UserForm;
import com.main.model.User;
import com.main.repository.UserRepository;
import com.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class WebMainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.getSession().invalidate();
            request.logout();
        } catch (ServletException e) {
            throw new Exception("Unable to Logout, exception is: " + e);
        }
        return "redirect:login";
    }

    @RequestMapping(value = "/list")
    public String list(ModelMap model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String addUser(ModelMap model) {
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String doAddUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {return "add-user";}
        if(userService.findByUsername(userForm.getUserName()) != null) {
            bindingResult.addError(new FieldError("userName", "userName", "Email or username is exist"));
            return "add-user";
        }

        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        user.setUserName(userForm.getUserName());
        userService.saveUser(user,null);
        return "redirect:list";
    }

    @RequestMapping(value = "/update-user/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        UserForm userForm = new UserForm();
        userForm.setName(user.getName());
        userForm.setPassword(user.getPassword());
        userForm.setUserName(user.getUserName());
        model.addAttribute("userForm", userForm);
        return "form";
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.POST)
    public String doUpdateUser(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) { return "update-user"; }
        if(userService.findByUsername(userForm.getUserName()) != null) {
            bindingResult.addError(new FieldError("userName", "userName", "Email or username is exist"));
            return "update-user";
        }

        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        user.setUserName(userForm.getUserName());
        userService.saveUser(user,null);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
    public String doDeleteUser() {return "redirect:list";}
}
