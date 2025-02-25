package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Admin;

public interface AdminService {

    Admin validateAdmin(String username, String password);

    List<Admin> getAllAdmins();

    Admin getAdminById(Integer adminid);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(Integer adminid);

}
