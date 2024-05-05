package cn.smxy.newsserver.controller;


import cn.smxy.newsserver.entity.MsBoard;
import cn.smxy.newsserver.entity.News;
import cn.smxy.newsserver.entity.UserInfo;
import cn.smxy.newsserver.service.BoardService;
import cn.smxy.newsserver.service.NewsService;
import cn.smxy.newsserver.util.JWTUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.border.Border;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class BoardController {
    @Autowired
    private BoardService boardService;
    //    http://localhost:8089/newsserver/board/findAll
    @GetMapping("/board/findAll")
    public Map<String,Object> findAll() {
        Map<String,Object> map = new HashMap<>();
        List<MsBoard> message = boardService.findAll();
        if(message!=null && message.size()>0){
            map.put("code",200);
            map.put("msg","查询所有留言成功");
            map.put("dataobject",message);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到留言");
            map.put("dataobject",null);
        }
        return map;
    }

    @PostMapping("/board/addBoard")
    public Map<String,Object>addUser(@RequestBody MsBoard msBoard){
        Map<String,Object>map=new HashMap<>();
        boardService.addBoard(msBoard);
        map.put("code",200);
        map.put("msg","添加留言成功");
        map.put("dataobject",null);
        return map;
    }



    @GetMapping("/board/delById")
    public Map<String,Object> delById(Integer id){
        Map<String,Object> map = new HashMap<>();
        boardService.delById(id);
        map.put("code",200);
        map.put("msg","删除留言成功");
        map.put("dataobject",null);
        return map;
    }
}
