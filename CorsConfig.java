package com.example.fitness.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//告诉框架，我是一个配置类
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//允许跨域访问的路径
                .allowedOriginPatterns("http://localhost*")//允许跨域访问的源（前端的IP地址）
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")//允许访问的方法
                .allowCredentials(true)//允许携带cookie
                .allowedHeaders("*")//允许所有的请求头
                .maxAge(3600);
    }
}
