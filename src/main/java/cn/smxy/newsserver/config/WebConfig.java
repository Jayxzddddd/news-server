package cn.smxy.newsserver.config;


import cn.smxy.newsserver.interceptor.LoginInterceptor;
import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/**").addPathPatterns("/user/getUserInfo").addPathPatterns("/board/**").addPathPatterns("/prize/**")
                .excludePathPatterns("/user/login").excludePathPatterns("/administrate/adminLogin");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\upload\\");
    }

}
