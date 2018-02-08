package com.zemoso.role.controller;


import com.zemoso.role.model.Role;
import com.zemoso.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(method= RequestMethod.GET, value="/roles")
    @ResponseBody
    public ResponseEntity<Map> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("roles", roles);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
