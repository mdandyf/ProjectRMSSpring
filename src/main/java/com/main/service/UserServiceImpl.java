package com.main.service;

import com.main.model.Privilege;
import com.main.model.Role;
import com.main.model.User;
import com.main.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.main.repository.PrivilegeRepository;
import com.main.repository.RoleRepository;
import com.main.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PrivilegeRepository privilegeRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
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
            user.setRole(role);
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    @Override
    public Role findUserRole(Long id) { return userRepository.findById(id).get().getRole(); }

    @Transactional
    @Override
    public List<Privilege> findUserPrivileges(Long id) { return userRepository.findById(id).get().getRole().getPrivileges();}


    @Transactional
    @Override
    public List<UserDetails> getUserDetails() {

        List<UserDetails> results = new ArrayList<>();
        for(User user : userRepository.findAll()) {
            results.add(getUserDetail(user.getUserName()));
        }

        return results;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public UserDetails getUserDetail(String username) {
        User user = userRepository.findByUsername(username);
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(user.getUserName());

        Role role = user.getRole();
        Set<String> setRole = new HashSet<>();
        setRole.add(role.getName());
        userDetails.setListRoles(setRole);

        Set<String> setPrivilegeString = new HashSet<>();
        for(Privilege privilege : role.getPrivileges()) {
            setPrivilegeString.add(privilege.getName());
        }

        userDetails.setListPrivileges(setPrivilegeString);
        return userDetails;
    }
}
