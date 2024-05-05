package cn.smxy.newsserver.dao;

import cn.smxy.newsserver.entity.NewsType;

import java.util.List;

public interface NewsTypeDao {
    public NewsType findById(Integer id);

    public List<NewsType> findAllNewsType();
}
