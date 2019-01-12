package com.main.controller;

import com.main.model.Privilege;
import com.main.model.Role;
import com.main.model.User;
import com.main.repository.UserRepository;
import com.main.service.PrivilegeService;
import com.main.service.RoleService;
import com.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebRestController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PrivilegeService privilegeService;

    //@PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/list/user/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @RequestMapping(value = "/list/users", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getListUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/list/details", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getListDetails() {
        return new ResponseEntity<>(userService.getUserDetails(), HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/list/user/roles/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getUserRole(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUserRole(id), HttpStatus.OK);
    }

    //@PreAuthorize("hasAuthority('EDIT_PRIVILEGE')")
    @RequestMapping(value = "/list/user/privileges/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getUserPrivileges(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findUserPrivileges(id), HttpStatus.OK);
    }

    //@PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/save-user", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        userService.saveUser(user, user.getId());
        return new ResponseEntity<>("User has been saved", HttpStatus.CREATED);
    }

    //@PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/save-role", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return new ResponseEntity<>("Role has been saved", HttpStatus.CREATED);
    }

    //@PreAuthorize("hasAnyAuthority('NEW_PRIVILEGE')")
    @RequestMapping(value = "/save-privilege", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> saveRole(@RequestBody Privilege privilege) {
        privilegeService.savePrivilege(privilege);
        return new ResponseEntity<>("Privilege has been saved", HttpStatus.CREATED);
    }
}