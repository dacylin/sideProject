package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{adminid}")
    public Admin getAdminById(@PathVariable Integer adminid) {
        return adminService.getAdminById(adminid);
    }

    @PostMapping
    public String addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
        return "新增管理者成功";
    }

    @PutMapping("/{adminid}")
    public String updateAdmin(@PathVariable Integer adminid, @RequestBody Admin admin) {
        admin.setAdminid(adminid);
        adminService.updateAdmin(admin);
        return "管理者修改成功";
    }

    @DeleteMapping("/{adminid}")
    public String deleteAdmin(@PathVariable Integer adminid) {
        adminService.deleteAdmin(adminid);
        return "管理者刪除成功";
    }
}
