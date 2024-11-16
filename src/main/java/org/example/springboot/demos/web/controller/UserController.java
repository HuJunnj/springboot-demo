package org.example.springboot.demos.web.controller;

import org.example.springboot.demos.web.entity.User;
import org.example.springboot.demos.web.middleware.Response;
import org.example.springboot.demos.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.lang.annotation.Repeatable;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jun
 * @since 2024-11-16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @RequestMapping("user")
    public Response<List<User>> getUsers(){
        return Response.success(iUserService.list());
    }
    @PostMapping("user")
    public Response<Boolean> addUser(@RequestBody User user){
        return Response.success(iUserService.save(user));
    }
    @DeleteMapping("user")
    public Response<Boolean> deleteUser(@RequestBody User user){
        return Response.success(iUserService.removeById(user));
    }
    @PutMapping("user")
    public Response<Boolean> updateUser(@RequestBody User user){
        return Response.success(iUserService.updateById(user));
    }

}
