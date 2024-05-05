package cn.smxy.newsserver.service;

import cn.smxy.newsserver.dao.UserDao;
import cn.smxy.newsserver.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delById(Integer id) {
        userDao.delById(id);

    }

    @Override
    public void add(UserInfo userInfo) {
        userDao.add(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        userDao.update(userInfo);
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        return userDao.login(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public UserInfo findOne(UserInfo userInfo) {
        return userDao.findOne(userInfo);
    }
}
