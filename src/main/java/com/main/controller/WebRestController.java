package com.main.controller;

import com.main.model.Privilege;
import com.main.model.Role;
import com.main.model.User;
import com.main.model.UserDetails;
import com.main.repository.UserRepository;
import com.main.service.PrivilegeService;
import com.main.service.RoleService;
import com.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
public class WebRestController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    PrivilegeService privilegeService;

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @RequestMapping(value = "/list/users", method = RequestMethod.GET)
    public Collection<User> getListUsers() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/list/details", method = RequestMethod.GET)
    public Collection<UserDetails> getListDetails() {
        return userService.getUserDetails();
    }

    @PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/list/roles/{id}", method = RequestMethod.GET)
    public Role getUserRoles(@PathParam("id") Long id) {
        return userRepository.findById(id).get().getRole();
    }

    @PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/list/privileges/{id}", method = RequestMethod.GET)
    public Collection<Privilege> getUserPrivileges(@PathParam("id") Long id) { return userRepository.findById(id).get().getRole().getPrivileges(); }

    @PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/save-user", method = RequestMethod.POST)
    public void saveUser(@PathParam("user") User user) { userRepository.save(user); }

    @PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/save-role", method = RequestMethod.POST)
    public void saveRole(@PathParam("role") Role role) { roleService.saveRole(role); }

    @PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/save-privilege", method = RequestMethod.POST)
    public void saveRole(@PathParam("privilege") Privilege privilege) { privilegeService.savePrivilege(privilege); }
}