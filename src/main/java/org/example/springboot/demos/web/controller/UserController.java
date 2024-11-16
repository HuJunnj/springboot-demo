package org.example.springboot.demos.web.controller;

import org.example.springboot.demos.web.entity.User;
import org.example.springboot.demos.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/demos.web/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    @RequestMapping("/get/users")
    public List<User> getUsers(){
        return iUserService.list();
    }

}
