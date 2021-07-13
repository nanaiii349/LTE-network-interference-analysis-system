package com.example.aclservice.service.impl;

import com.example.aclservice.entity.User;
import com.example.aclservice.mapper.UserMapper;
import com.example.aclservice.service.UserService;
import com.example.commonutils.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.commonutils.JwtUtils;
import com.example.servicebase.exceptionhandler.NanaiiiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author nanaiii
 * @since 2021-04-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }


//    @Autowired
//    private UserService userService;
    //登录的方法
    @Override
    public User login(User member) {
        //获取登录手机号和密码
        String username = member.getUsername();
        String password = member.getPassword();

        //手机号和密码非空判断
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new NanaiiiException(20001,"用户名或密码为空");
        }

        //判断手机号是否正确
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User mobileMember = baseMapper.selectOne(wrapper);
        //判断查询对象是否为空
        if(mobileMember == null) {//没有这个手机号
            throw new NanaiiiException(20001,"未查询到用户");
        }

        //判断密码
        //因为存储到数据库密码肯定加密的
        //把输入的密码进行加密，再和数据库密码进行比较
        //加密方式 MD5
        if(!MD5.encrypt(password).equals(mobileMember.getPassword())) {
            throw new NanaiiiException(20001,"密码错误");
        }
//
//        //判断用户是否禁用
//        if(mobileMember.getIsDisabled()) {
//            throw new NanaiiiException(20001,"用户被禁止使用");
//        }

        //登录成功
        //生成token字符串，使用jwt工具类
//        System.out.println(mobileMember.getId());
//        System.out.println(mobileMember.getUsername());
//        String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getUsername());
//        return jwtToken;
        return mobileMember;
    }

}
