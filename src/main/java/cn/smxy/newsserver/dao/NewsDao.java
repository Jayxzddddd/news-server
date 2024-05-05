package cn.smxy.newsserver.dao;

import cn.smxy.newsserver.entity.News;

import java.util.List;

public interface NewsDao {
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
}
