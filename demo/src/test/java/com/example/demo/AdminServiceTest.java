package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void testGetAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();

        admins.forEach(admin -> {
            System.out.println("Admin ID: " + admin.getAdminid());
            System.out.println("Username: " + admin.getAdminusername());
            System.out.println("Password: " + admin.getAdminpassword());
            System.out.println("Email: " + admin.getAdminemail());
            System.out.println("Role: " + admin.getAdminrole());
            System.out.println("-------------------------");
        });
    }

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin();
        admin.setAdminusername("newadmin");
        admin.setAdminpassword("password111");
        admin.setAdminemail("newadmin@example.com");
        admin.setAdminrole("admin");
        adminService.addAdmin(admin);
        System.out.println("新增管理者成功");
    }

    @Test
    public void testUpdateAdmin() {
        Admin admin = adminService.getAdminById(1);
        if (admin != null) {
            admin.setAdminusername("updatedadmin");
            adminService.updateAdmin(admin);
            System.out.println("更新管理者成功");
        }
    }

    @Test
    public void testDeleteAdmin() {
        adminService.deleteAdmin(4);
        System.out.println("刪除管理者成功");
    }
}
