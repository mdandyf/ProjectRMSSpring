package com.main.service;

import com.main.model.User;
import com.main.model.UserDetails;

import java.util.List;

public interface UserService {
    void saveUser(User user, Long idRole);
    User findByUsername(String username);
    UserDetails getUserDetail(String username);
    List<UserDetails> getUserDetails();
}
