package cn.smxy.newsserver.dao;

import cn.smxy.newsserver.entity.UserInfo;

import java.util.List;

public interface UserDao {
    public List<UserInfo> findAll();
    public void delById(Integer id);
    public void add(UserInfo userInfo);
    public void update(UserInfo userInfo);

    public UserInfo findOne(UserInfo userInfo);
    //个人中心
    public UserInfo findById(Integer id);
    public UserInfo login(UserInfo userInfo);
}
