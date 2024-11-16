package org.example.springboot.demos.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboot.demos.web.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jun
 * @since 2024-11-16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
