package cn.smxy.newsserver.controller;

import cn.smxy.newsserver.entity.Admin;
import cn.smxy.newsserver.entity.News;
import cn.smxy.newsserver.service.AdminService;
import cn.smxy.newsserver.service.NewsService;
import cn.smxy.newsserver.util.JWTUtil;
import com.auth0.jwt.JWT;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;
    //    http://localhost:8089/ryansystemserver/admin/adminfindAll
    @GetMapping("/admin/adminfindAll")
    public Map<String,Object> adminfindAll(){
        Map<String,Object> map = new HashMap<>();
        List<Admin> admins = adminService.findAll();
        if(admins!=null && admins.size()>0){
            map.put("code",200);
            map.put("msg","查询所有管理员成功");
            map.put("dataobject",admins);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到该数据");
            map.put("dataobject",null);
        }
        return map;
    }
    @PostMapping("/administrate/adminLogin")
    public Map<String,Object> adminLogin(@RequestBody Admin admin){
        Map<String,Object> map  = new HashMap<>();
        Admin a = adminService.Login(admin);
        if(a != null){
            //登录成功
            Map<String,String> payload = new HashMap<>();
            payload.put("id",a.getId().toString());
            payload.put("username",a.getUsername());
            String token = JWTUtil.createToken(payload);

            map.put("code",200);
            map.put("msg","登录成功");
            map.put("token",token);
            map.put("userId",a.getId());
            map.put("username",a.getUsername());
            return  map;
        }else {
            //登录失败
            map.put("code",500);
            map.put("msg","管理员用户名或密码错误");
            map.put("token",null);
            map.put("userId",null);
            map.put("username",null);
            return map;
        }
    }

}
