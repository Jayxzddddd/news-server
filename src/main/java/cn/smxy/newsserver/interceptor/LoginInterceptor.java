package cn.smxy.newsserver.interceptor;

import cn.smxy.newsserver.util.JWTUtil;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("token");
        System.out.println("token="+token);
        Map<String,Object>map = new HashMap<>();
        if(token==null||"".equals(token)||"null".equals(token)){
            map.put("code",500);
            map.put("msg","请您先登录哦！");
            String jsonstring = new Gson().toJson(map);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(jsonstring);
            return false;
        }
        try{
            DecodedJWT decodedJWT = JWTUtil.verifyToken(token);
            return true;
        }catch (SignatureVerificationException e){
            e.printStackTrace();
            map.put("code",500);
            map.put("msg","签名不正确");
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("code",500);
            map.put("msg","签名算法不正确");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("code",500);
            map.put("msg","token过期了");
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",500);
            map.put("msg","发生异常");
        }
        String jsonstring = new Gson().toJson(map);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonstring);
        return false;
    }
}
