package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping
    public void addAdmin(@RequestBody Admin admin) {
        adminService.addAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdminById(id);
    }

    @PutMapping("/{id}/password")
    public void updateAdminPassword(@PathVariable int id, @RequestBody Map<String, String> body) {
        String password = body.get("password");
        adminService.updateAdminPassword(id, password);
    }
}
