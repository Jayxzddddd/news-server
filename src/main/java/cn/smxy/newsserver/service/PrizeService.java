package cn.smxy.newsserver.service;

import cn.smxy.newsserver.entity.Prize;

import java.util.List;

public interface PrizeService {
    public List<Prize> findAll();
    public void delById(Integer id);
    public void add(Prize prize);
    public void update(Prize prize);
}
