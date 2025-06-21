package org.example.springboot.demos.web.middleware;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 匹配所有请求路径
                .allowedOriginPatterns("*") // 允许所有来源（Spring Boot 2.4+ 推荐用这个）
                .allowedMethods("*")        // 允许所有 HTTP 方法：GET, POST, PUT, DELETE, etc.
                .allowedHeaders("*")        // 允许所有请求头
                .allowCredentials(true)     // 允许发送 Cookie
                .maxAge(3600);              // 预检请求的缓存时间（秒）
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")  // 设置拦截路径
                .excludePathPatterns("/login","/error"); // 设置不拦截的路径
    }
}
