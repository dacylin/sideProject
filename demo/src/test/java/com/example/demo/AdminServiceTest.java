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
    public void testValidateAdmin() {
        Admin admin = adminService.validateAdmin("admin1", "password123");
        if (admin != null) {
            System.out.println("登入成功：");
            System.out.println("Admin ID: " + admin.getAdminid());
            System.out.println("Username: " + admin.getAdminusername());
        } else {
            System.out.println("用户名或密碼錯誤！");
        }
    }

    @Test
    public void testGetAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();

        admins.forEach(admin -> {
            System.out.println("Admin ID: " + admin.getAdminid());
            System.out.println("Username: " + admin.getAdminusername());
            System.out.println("Password: " + admin.getAdminpassword());
            System.out.println("Email: " + admin.getAdminemail());
            System.out.println("-------------------------");
        });
    }

    @Test
    public void testAddAdmin() {
        Admin admin = new Admin();
        admin.setAdminusername("newadmin");
        admin.setAdminpassword("password111");
        admin.setAdminemail("newadmin@example.com");
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
        } else {
            System.out.println("未找到 ID 為 1 的管理者");
        }
    }

    @Test
    public void testDeleteAdmin() {
        adminService.deleteAdmin(8);
        System.out.println("刪除管理者成功");
    }

}
