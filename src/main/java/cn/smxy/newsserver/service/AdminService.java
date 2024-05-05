package cn.smxy.newsserver.service;

import cn.smxy.newsserver.entity.Admin;
import cn.smxy.newsserver.entity.UserInfo;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();
    public Admin Login(Admin admin);
}
