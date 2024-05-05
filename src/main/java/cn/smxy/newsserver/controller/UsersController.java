package cn.smxy.newsserver.controller;


import cn.smxy.newsserver.entity.UserInfo;
import cn.smxy.newsserver.service.UserService;
import cn.smxy.newsserver.util.JWTUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/user/findAll")
    public Map<String,Object>findAll(){
       Map<String,Object>map=new HashMap<>();
        List<UserInfo>userInfoList = userService.findAll();
        if(userInfoList!=null && userInfoList.size()>0){
            map.put("code",200);
            map.put("msg","查询所有用户列表成功");
            map.put("dataobject",userInfoList);
        }
        else {
            map.put("code",404);
            map.put("msg","没有查询到用户数据");
            map.put("dataobject",null);
        }
        return map;
    }

    @GetMapping("/admin/user/delById")
    public Map<String,Object>delById(Integer id){
        Map<String,Object>map=new HashMap<>();
        userService.delById(id);
        map.put("code",200);
        map.put("msg","删除用户成功");
        map.put("dataobject",null);
        return map;
    }

    @PostMapping("/user/addUser")
    public Map<String,Object>addUser(@RequestBody UserInfo userInfo){
        Map<String,Object>map=new HashMap<>();
        userService.add(userInfo);
        map.put("code",200);
        map.put("msg","添加用户成功");
        map.put("dataobject",null);
        return map;
    }
    @PostMapping("/admin/user/editUser")
    public Map<String,Object>editUser(@RequestBody UserInfo userInfo){
        Map<String,Object>map=new HashMap<>();
        if(userInfo.getId()!=null){
            userService.update(userInfo);
            map.put("code",200);
            map.put("msg","修改用户信息成功");
            map.put("dataobject",null);
        }
        else {
            userService.add(userInfo);
            map.put("code",200);
            map.put("msg","添加用户成功");
            map.put("dataobject",null);
        }
        return map;
    }

    @PostMapping("/user/login")
    public Map<String,Object>login(@RequestBody UserInfo userInfo){
        Map<String,Object>map=new HashMap<>();
        UserInfo  u= userService.login(userInfo);
        if(u!=null){
            Map<String,String>payload = new HashMap<>();
            payload.put("id",u.getId().toString());
            payload.put("username",u.getUsername());
            String token = JWTUtil.createToken(payload);

            map.put("code",200);
            map.put("msg","登录成功");
            map.put("token",token);
            map.put("userId",u.getId());
            map.put("username",u.getUsername());
            return map;
        }
        else {
            map.put("code",500);
            map.put("msg","用户名或密码错误");
            map.put("token",null);
            map.put("userId",null);
            map.put("username",null);
            return map;
        }
    }

    @PostMapping("/user/findOne")
    public Map<String,Object> findOne(@RequestBody UserInfo userInfo){
        Map<String,Object>map=new HashMap<>();
        UserInfo  u= userService.findOne(userInfo);
        map.put("code",200);
        map.put("msg","获取成功");
        map.put("dataobject",u);
        return map;
    }

    //用户中心代码
    @GetMapping("/user/getUserInfo")
    public Map<String,Object>getUserInfo(HttpServletRequest request){
        Map<String,Object>map = new HashMap<>();
        String token = request.getHeader("token");
        DecodedJWT decodedJWT = JWTUtil.verifyToken(token);
        String strId= decodedJWT.getClaim("id").asString();
        int id = Integer.parseInt(strId);
        UserInfo userInfo = userService.findById(id);

        map.put("code",200);
        map.put("msg","查找用户信息成功");
        map.put("dataobject",userInfo);
        return map;
    }


}
