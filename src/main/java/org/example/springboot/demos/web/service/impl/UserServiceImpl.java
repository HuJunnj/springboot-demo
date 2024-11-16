package org.example.springboot.demos.web.service.impl;

import org.example.springboot.demos.web.entity.User;
import org.example.springboot.demos.web.mapper.UserMapper;
import org.example.springboot.demos.web.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jun
 * @since 2024-11-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Cacheable(value = "userCache", key = "#redisKey")
    @Override
    public List<User> getLi1st(String redisKey) {
        return this.list();
    }
    @CacheEvict(value = "userCache", key = "#redisKey")
    @Override
    public Boolean addUser(User user,String redisKey) {
        return this.save(user);
    }
    @CacheEvict(value = "userCache", key = "#redisKey")
    @Override
    public Boolean deleteUser(User user,String redisKey) {
        return this.removeById(user.getId());
    }
    @CacheEvict(value = "userCache", key = "#redisKey")
    @Override
    public Boolean updateUser(User user,String redisKey) {
        return this.updateById(user);
    }
}