package com.nuevocredito.inmocredit.security.service;

import com.nuevocredito.inmocredit.security.entity.Role;
import com.nuevocredito.inmocredit.security.enums.RoleName;
import com.nuevocredito.inmocredit.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Role role){
        roleRepository.save(role);
    }

}
