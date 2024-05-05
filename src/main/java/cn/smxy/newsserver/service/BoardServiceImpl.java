package cn.smxy.newsserver.service;

import cn.smxy.newsserver.dao.BoardDao;
import cn.smxy.newsserver.dao.NewsDao;
import cn.smxy.newsserver.entity.MsBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDao boardDao;
    @Override
    public List<MsBoard> findAll() {
        return boardDao.findAll();
    }

    @Override
    public void addBoard(MsBoard msBoard) {
        boardDao.addBoard(msBoard);
    }

    @Override
    public void delById(Integer id) {
        boardDao.delById(id);
    }
}
