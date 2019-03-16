package com.apt.project4.service;

import com.apt.project4.model.Role;
import com.apt.project4.model.RoleName;
import com.apt.project4.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

//    public Role findByRoleName(RoleName roleName) {
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

}
