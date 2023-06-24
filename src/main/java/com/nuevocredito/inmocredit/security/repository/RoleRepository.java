package com.nuevocredito.inmocredit.security.repository;

import com.nuevocredito.inmocredit.security.entity.Role;
import com.nuevocredito.inmocredit.security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
