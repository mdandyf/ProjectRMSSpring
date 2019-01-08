package service;

import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import repository.RoleRepository;

public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
