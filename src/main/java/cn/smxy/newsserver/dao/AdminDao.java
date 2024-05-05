package cn.smxy.newsserver.dao;

import cn.smxy.newsserver.entity.Admin;
import cn.smxy.newsserver.entity.UserInfo;

import java.util.List;

public interface AdminDao {
    public List<Admin> findAll();
    public Admin Login(Admin admin);
}
