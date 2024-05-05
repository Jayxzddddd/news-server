package cn.smxy.newsserver.controller;

import cn.smxy.newsserver.entity.News;
import cn.smxy.newsserver.entity.NewsType;
import cn.smxy.newsserver.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class NewsController {
    @Autowired
    private NewsService newsService;

    @GetMapping("/news/findHomeNewsTop3")
    public Map<String,Object> findHomeNewsTop3(){
        Map<String,Object> map = new HashMap<>();
        List<News>newsList = newsService.findHomeNewsTop3();
        if(newsList!=null && newsList.size()>0){
            map.put("code",200);
            map.put("msg","查询最新国内新闻列表成功");
            map.put("dataobject",newsList);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到该数据");
            map.put("dataobject",null);
        }
        return map;
    }
    @GetMapping("/news/findInternationalNewsTop3")
    public Map<String,Object> findInternationalNewsTop3(){
        Map<String,Object> map = new HashMap<>();
        List<News>newsList = newsService.findInternationalNewsTop3();
        if(newsList!=null && newsList.size()>0){
            map.put("code",200);
            map.put("msg","查询最新国际新闻列表成功");
            map.put("dataobject",newsList);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到该数据");
            map.put("dataobject",null);
        }
        return map;
    }

//    http://localhost:8089/newsserver/news/findArmyNewsTop3
    @GetMapping("/news/findArmyNewsTop3")
    public Map<String,Object> findArmyNewsTop3(){
        Map<String,Object> map = new HashMap<>();
        List<News>newsList = newsService.findArmyNewsTop3();
        if(newsList!=null && newsList.size()>0){
            map.put("code",200);
            map.put("msg","查询最新军事新闻列表成功");
            map.put("dataobject",newsList);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到该数据");
            map.put("dataobject",null);
        }
        return map;
    }

    @GetMapping("/news/findByTypeId")
    public Map<String,Object> findByTypeId(Integer typeId){
        Map<String,Object> map = new HashMap<>();
        List<News>newsList = newsService.findByTypeId(typeId);
        if(newsList!=null && newsList.size()>0){
            map.put("code",200);
            map.put("msg","按类别查询新闻成功");
            map.put("dataobject",newsList);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到该数据");
            map.put("dataobject",null);
        }
        return map;
    }

    @GetMapping("/news/findAll")
    public Map<String,Object> findAll(){
        Map<String,Object> map = new HashMap<>();
        List<News>newsList = newsService.findAll();
        if(newsList!=null && newsList.size()>0){
            map.put("code",200);
            map.put("msg","查询所有新闻列表成功");
            map.put("dataobject",newsList);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到该数据");
            map.put("dataobject",null);
        }
        return map;
    }
    @GetMapping("/newsType/findAll")
    public Map<String,Object> findAll2(){
        Map<String,Object> map = new HashMap<>();
        List<NewsType>newsList =newsService.findAllNewsType();
        if(newsList!=null && newsList.size()>0){
            map.put("code",200);
            map.put("msg","查询所有新闻类别成功");
            map.put("dataobject",newsList);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到该数据");
            map.put("dataobject",null);
        }
        return map;
    }

    @GetMapping("/admin/delNewsById")
    public Map<String,Object> delNewsById(Integer id){
        Map<String,Object> map = new HashMap<>();
        newsService.delNewsById(id);
        map.put("code",200);
        map.put("msg","删除信息成功");
        map.put("dataobject",null);
        return map;
    }

    @PostMapping("/admin/editNews")
    public Map<String,Object> editNews(@RequestBody News news){
        Map<String,Object> map = new HashMap<>();
        if(news.getId()==null){
            //添加
            newsService.addNews(news);
            map.put("code",200);
            map.put("msg","添加新闻成功");
            map.put("dataobject",null);
        }
        else {
            //修改
            newsService.updateNews(news);
            map.put("code",200);
            map.put("msg","修改新闻成功");
            map.put("dataobject",null);
        }
        return map;
    }
}
