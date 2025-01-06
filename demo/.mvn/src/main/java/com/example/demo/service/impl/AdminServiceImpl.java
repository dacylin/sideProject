package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin validateAdmin(String username, String password) {
        Admin admin = adminMapper.findByUsername(username);
        if (admin != null && admin.getAdminpassword().equals(password)) {
            return admin;
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.getAllAdmins();
    }

    @Override
    public Admin getAdminById(Integer adminid) {
        return adminMapper.getAdminById(adminid);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.addAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Integer adminid) {
        adminMapper.deleteAdmin(adminid);
    }

}
