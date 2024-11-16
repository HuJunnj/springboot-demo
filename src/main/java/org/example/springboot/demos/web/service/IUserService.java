package org.example.springboot.demos.web.service;

import org.example.springboot.demos.web.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jun
 * @since 2024-11-16
 */
public interface IUserService extends IService<User> {
    List<User> getLi1st(String redisKey);
    Boolean addUser(User user, String redisKey);
    Boolean deleteUser(User param, String redisKey);
    Boolean updateUser(User user, String redisKey);
}
