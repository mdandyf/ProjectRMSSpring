package com.main.controller;

import com.main.model.Privilege;
import com.main.model.Role;
import com.main.model.User;
import com.main.service.PrivilegeService;
import com.main.service.RoleService;
import com.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebRestController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PrivilegeService privilegeService;

    @Autowired
    UserDetailsService userDetailsService;

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @RequestMapping(value = "/rest/auth", method = RequestMethod.GET)
    public ResponseEntity<Object> authenticate() {
        return new ResponseEntity<>("User is authorized", HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @RequestMapping(value = "/rest/list/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @RequestMapping(value = "/rest/list/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getListUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/rest/list/details", method = RequestMethod.GET)
    public ResponseEntity<Object> getListDetails() {
        return new ResponseEntity<>(userService.getUserDetails(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/rest/list/user/roles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserRole(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUserRole(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/rest/list/user/privileges/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserPrivileges(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUserPrivileges(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/rest/save/user", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        userService.saveUser(user, user.getId());
        return new ResponseEntity<>("User has been saved", HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/rest/save/role", method = RequestMethod.POST)
    public ResponseEntity<Object> saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return new ResponseEntity<>("Role has been saved", HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/rest/save/privilege", method = RequestMethod.POST)
    public ResponseEntity<Object> savePrivilege(@RequestBody Privilege privilege) {
        privilegeService.savePrivilege(privilege);
        return new ResponseEntity<>("Privilege has been saved", HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('DELETE_PRIVILEGE')")
    @RequestMapping(value = "/rest/delete/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User has been deleted", HttpStatus.OK);
    }


}