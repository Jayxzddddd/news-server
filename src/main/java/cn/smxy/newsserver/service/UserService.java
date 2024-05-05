package cn.smxy.newsserver.service;

import cn.smxy.newsserver.entity.UserInfo;

import java.util.List;

public interface UserService {
    public List<UserInfo> findAll();
    public void delById(Integer id);
    public void add(UserInfo userInfo);
    public void update(UserInfo userInfo);
    public UserInfo login(UserInfo userInfo);
    public UserInfo findById(Integer id);
    public UserInfo findOne(UserInfo userInfo);
}
