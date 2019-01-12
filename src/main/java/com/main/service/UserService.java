package com.main.service;

import com.main.model.Privilege;
import com.main.model.Role;
import com.main.model.User;
import com.main.model.UserDetails;

import java.util.List;

public interface UserService {
    void saveUser(User user, Long idRole);
    User findByUsername(String username);
    User findById(Long id);
    Role findUserRole(Long id);
    List<Privilege> findUserPrivileges(Long id);
    List<User> getUsers();
    UserDetails getUserDetail(String username);
    List<UserDetails> getUserDetails();
}
