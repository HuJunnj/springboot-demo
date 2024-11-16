package org.example.springboot.demos.web.login;

import org.example.springboot.demos.web.middleware.JwtUtils;
import org.example.springboot.demos.web.middleware.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class loginController {

    // 登录接口，返回生成的 JWT Token
    @GetMapping("/login")
    public Response<TokenInfo> login() {
        String token = JwtUtils.generateToken("john_doe");
        Response<TokenInfo> result = Response.success(new TokenInfo(token));
        return result;
    }

    // 受保护的用户信息接口，需要有效的 JWT Token
    @GetMapping("/user")
    public Response<String> getUserInfo() {
        // 假设已经通过 JWT 校验并且用户信息已经在 SecurityContextHolder 中
        return Response.success("User info: John Doe");
    }
}
