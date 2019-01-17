package com.main.service;

import com.main.model.Privilege;
import com.main.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.main.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.main.model.User user = userRepository.findByUsername(s);
        if(user == null) {throw new UsernameNotFoundException("User not found by name: " + s);}
        org.springframework.security.core.userdetails.User userDetails = null;
        try {
            userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true, true, true, true, getAuthorities(user.getRole()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetails ;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Role role) {
        return getGrantedAuthorities(getPrivileges(role));
    }

    private List<String> getPrivileges(Role role) {
        List<String> privileges = new ArrayList<>();
        for(Privilege privilege : role.getPrivileges()) {
            privileges.add(privilege.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
