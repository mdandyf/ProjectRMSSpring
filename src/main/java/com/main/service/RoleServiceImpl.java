package com.main.service;

import com.main.model.Role;
import com.main.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  RoleRepository roleRepository;

  public RoleServiceImpl() {
  }

  @Override
  public void saveRole(Role role) {
    roleRepository.save(role);
  }
}
