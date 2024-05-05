package cn.smxy.newsserver.dao;

import cn.smxy.newsserver.entity.Prize;

import java.util.List;

public interface PrizeDao {
    public List<Prize> findAll();
    public void delById(Integer id);
    public void add(Prize prize);
    public void update(Prize prize);
}
