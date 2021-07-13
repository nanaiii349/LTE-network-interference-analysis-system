package com.example.aclservice.service;

import com.example.aclservice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.aclservice.entity.vo.RegisterVo;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-25
 */
public interface UserService extends IService<User> {

    // 从数据库中取出用户信息
    User selectByUsername(String username);

    //登录的方法
//    String login(User member);
    User login(User member);
}
