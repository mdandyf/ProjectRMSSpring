package service;

import model.Privilege;
import model.Role;
import model.User;
import model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import repository.PrivilegeRepository;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PrivilegeRepository privilegeRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void saveUser(User user, Long idRole) {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Role role;
            if(idRole == null) {
                role = roleRepository.findByName("USER");
            }else {
                role = roleRepository.findById(idRole).get();
            }
            user.setRoles(new HashSet<>(Arrays.asList(role)));
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDetails findByUsername(String username) {
        return null;
    }

    @Override
    public UserDetails getUserDetail(String username) {
        return null;
    }
}
