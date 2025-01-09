package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Admin;

public interface AdminService {

    List<Admin> getAllAdmins();

    void addAdmin(Admin admin);

    void deleteAdminById(int id);

    void updateAdminPassword(int id, String password);

}
