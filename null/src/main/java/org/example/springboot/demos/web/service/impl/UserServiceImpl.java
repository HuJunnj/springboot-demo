package org.example.springboot.demos.web.service.impl;

import org.example.springboot.demos.web.entity.User;
import org.example.springboot.demos.web.mapper.UserMapper;
import org.example.springboot.demos.web.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
