package org.example.springboot.demos.web.middleware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化方法，可以用于加载配置
        logger.info("初始化方法，可以用于加载配置");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 在请求处理之前
        logger.info("Request intercepted by MyFilter");

        // 继续执行下一个过滤器或目标请求
        chain.doFilter(request, response);

        // 在响应返回之前
        logger.info("Response intercepted by MyFilter");
    }

    @Override
    public void destroy() {
        // 过滤器销毁时执行
        logger.info("过滤器销毁时");
    }
}
