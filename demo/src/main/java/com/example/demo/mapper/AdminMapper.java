package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Admin;

@Mapper
public interface AdminMapper {

    Admin findByUsername(String username);

    List<Admin> getAllAdmins();

    Admin getAdminById(Integer adminid);

    int addAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdmin(Integer adminid);

}