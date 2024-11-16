package org.example.springboot.demos.web.middleware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    private static final String Authorization = "Authorization";
    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理之前
        logger.info("Request intercepted by MyInterceptor");
       String Token = request.getHeader("Authorization");
       if (Token.isEmpty()) {
           throw new Exception("没有正确设置Token");
       } else {
           if (!JwtUtils.isValidToken(Token)) {
               // 如果 token 无效，返回 401 未授权状态
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               response.getWriter().write("Unauthorized: Invalid or missing token");
               return false;  // 阻止请求继续执行
           } else {
               return true;
           }
       }
        // 返回 true 表示继续处理请求，返回 false 则中止请求
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        // 请求处理之后，视图渲染之前
        logger.info("Response intercepted by MyInterceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 请求处理完成之后，视图渲染之后
        logger.info("After Completion");
    }
}
