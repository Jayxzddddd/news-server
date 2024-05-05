package cn.smxy.newsserver.service;

import cn.smxy.newsserver.dao.NewsDao;
import cn.smxy.newsserver.dao.NewsTypeDao;
import cn.smxy.newsserver.entity.News;
import cn.smxy.newsserver.entity.NewsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private NewsTypeDao newsTypeDao;
    @Override
    public List<News> findHomeNewsTop3() {
        return newsDao.findHomeNewsTop3();
    }

    @Override
    public List<News> findInternationalNewsTop3() {
        return newsDao.findInternationalNewsTop3();
    }

    @Override
    public List<News> findArmyNewsTop3() {
        return newsDao.findArmyNewsTop3();
    }

    @Override
    public List<News> findByTypeId(Integer typeId) {
        return newsDao.findByTypeId(typeId);
    }

    @Override
    public List<News> findAll() {
        return newsDao.findAll();
    }

    @Override
    public void delNewsById(Integer id) {
        newsDao.delNewsById(id);
    }

    @Override
    public void addNews(News news) {
        newsDao.addNews(news);
    }

    @Override
    public void updateNews(News news) {
        newsDao.updateNews(news);
    }

    @Override
    public List<NewsType> findAllNewsType(){
        return newsTypeDao.findAllNewsType();
    }
}
