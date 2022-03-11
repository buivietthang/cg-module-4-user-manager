package com.codegym.vn.service;

import com.codegym.vn.model.Role;
import com.codegym.vn.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepo roleRepo;

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleRepo.findAll();
    }
}
