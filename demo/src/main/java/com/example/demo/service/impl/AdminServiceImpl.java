package com.example.demo.service.impl;

import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.findAll();
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.insert(admin);
    }

    @Override
    public void deleteAdminById(int id) {
        adminMapper.deleteById(id);
    }

    @Override
    public void updateAdminPassword(int id, String password) {
        adminMapper.updatePassword(id, password);
    }
}
