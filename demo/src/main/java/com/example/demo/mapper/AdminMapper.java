package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Admin;

@Mapper
public interface AdminMapper {
    List<Admin> findAll();

    int insert(Admin admin);

    int deleteById(int id);

    int updatePassword(@Param("id") int id, @Param("password") String password);
}