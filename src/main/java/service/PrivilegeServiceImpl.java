package service;

import model.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PrivilegeRepository;

public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    PrivilegeRepository privilegeRepository;

    @Override
    public void savePrivilege(Privilege privilege) {
        privilegeRepository.save(privilege);
    }
}
