package cn.smxy.newsserver.service;

import cn.smxy.newsserver.entity.News;
import cn.smxy.newsserver.entity.NewsType;

import java.util.List;

public interface NewsService {
    public List<News> findHomeNewsTop3();
    public List<News> findInternationalNewsTop3();
    public List<News> findArmyNewsTop3();
    //按类别查询
    public List<News> findByTypeId(Integer typeId);
    //查找所有
    public List<News> findAll();

    public void delNewsById(Integer id);
    public void addNews(News news);
    public void updateNews(News news);


    public List<NewsType> findAllNewsType();
}
