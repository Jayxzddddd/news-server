package cn.smxy.newsserver.service;

import cn.smxy.newsserver.entity.MsBoard;

import java.util.List;

public interface BoardService {
    public List<MsBoard> findAll();
    public void addBoard(MsBoard msBoard);
    public void delById(Integer id);
}
