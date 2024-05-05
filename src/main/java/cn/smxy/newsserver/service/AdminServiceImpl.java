package cn.smxy.newsserver.service;

import cn.smxy.newsserver.dao.AdminDao;
import cn.smxy.newsserver.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Admin Login(Admin admin) {
        return adminDao.Login(admin);
    }
}
