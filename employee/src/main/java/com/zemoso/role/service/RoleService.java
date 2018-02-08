package com.zemoso.role.service;

import com.zemoso.role.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RoleService {
    public List<Role> getAllRoles();

}
