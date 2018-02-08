package com.zemoso.role.service;

import com.zemoso.role.model.Role;
import com.zemoso.role.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return (List<Role>)roleRepository.findAll();
    }
}
