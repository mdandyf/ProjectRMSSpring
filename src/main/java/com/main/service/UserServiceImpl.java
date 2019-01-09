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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public UserServiceImpl() {}

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
    public User findByUsername(String username) {
       return userRepository.findByUserName(username);
    }

    @Override
    public UserDetails getUserDetail(String username) {
        User user = userRepository.findByUserName(username);
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(user.getUserName());

        Set<Role> setRoles = user.getRoles();
        Set<String> setRoleString = new HashSet<>();
        for(Role role : setRoles) {
            setRoleString.add(role.getName());
        }
        userDetails.setListRoles(setRoleString);

        Set<String> setPrivilegeString = new HashSet<>();
        List<Privilege> listPrivilege = privilegeRepository.findAll();
        for(Privilege privilege : listPrivilege) {

        }

        userDetails.setListPrivileges(setPrivilegeString);
        return userDetails;
    }
}
