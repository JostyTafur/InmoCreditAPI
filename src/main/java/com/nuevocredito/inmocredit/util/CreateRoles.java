package com.nuevocredito.inmocredit.util;

import com.nuevocredito.inmocredit.security.entity.Role;
import com.nuevocredito.inmocredit.security.enums.RoleName;
import com.nuevocredito.inmocredit.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception{
        //SOLO DEBEMOS EJECUTARLO UNA SOLA VEZ
        /*Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        Role roleUser = new Role(RoleName.ROLE_USER);
        roleService.save(roleAdmin);
        roleService.save(roleUser);*/
    }
}
