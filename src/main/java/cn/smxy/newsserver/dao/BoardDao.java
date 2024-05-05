package cn.smxy.newsserver.dao;

import cn.smxy.newsserver.entity.MsBoard;


import java.util.List;

public interface BoardDao {
    public List<MsBoard> findAll();
    public void addBoard(MsBoard msBoard);
    public void delById(Integer id);
}
