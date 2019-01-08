package service;

import model.Privilege;
import model.Role;
import model.User;
import model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.PrivilegeRepository;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            List<User> users = privilege.getUsers();
            for(User userDetail : users) {
                if(userDetail.getUserName().equals(username)) {
                    setPrivilegeString.add(privilege.getName());
                    break;
                }
            }
        }

        userDetails.setListPrivileges(setPrivilegeString);
        return userDetails;
    }
}
