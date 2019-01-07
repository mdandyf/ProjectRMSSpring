package service;

import model.User;
import model.UserDetails;

public interface UserService {
    void saveUser(User user, Long idRole);
    UserDetails findByUsername(String username);
    UserDetails getUserDetail(String username);
}
