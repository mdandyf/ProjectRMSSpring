package com.main.service;

import com.main.model.User;
import com.main.model.UserDetails;

public interface UserService {
    void saveUser(User user, Long idRole);
    User findByUsername(String username);
    UserDetails getUserDetail(String username);
}
