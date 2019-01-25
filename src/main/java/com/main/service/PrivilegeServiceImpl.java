package com.main.service;

import com.main.model.Privilege;
import com.main.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
  @Autowired
  PrivilegeRepository privilegeRepository;

  public PrivilegeServiceImpl() {
  }

  @Override
  public void savePrivilege(Privilege privilege) {
    privilegeRepository.save(privilege);
  }
}
