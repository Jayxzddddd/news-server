package cn.smxy.newsserver.service;

import cn.smxy.newsserver.dao.PrizeDao;
import cn.smxy.newsserver.entity.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrizeServiceImpl implements PrizeService{
    @Autowired
    private PrizeDao prizeDao;
    @Override
    public List<Prize> findAll() {
        return prizeDao.findAll();
    }

    @Override
    public void delById(Integer id) {
        prizeDao.delById(id);
    }

    @Override
    public void add(Prize prize) {
        prizeDao.add(prize);
    }

    @Override
    public void update(Prize prize) {
        prizeDao.update(prize);
    }
}
