package com.example.center.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.center.entity.demo;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.center.entity.UcenterMember;
import com.example.center.entity.vo.RegisterVo;
import com.example.center.service.UcenterMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author Luo Tianyou
 * @since 2021-03-12
 */
@RestController
@RequestMapping("/center/ucenter-member")
//@CrossOrigin //解决跨域
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    @PostMapping("send")
    public R demo(@RequestBody demo Demo){
        System.out.println(Demo.getOperate());
        return R.ok();
    }

    //登录
    @PostMapping("login")
    public R loginUser(@RequestBody UcenterMember member) {
        //member对象封装手机号和密码
        //调用service方法实现登录
        //返回token值，使用jwt生成
        String token = memberService.login(member);
        return R.ok().data("token",token);
    }

    //注册
    @PostMapping("register")
    public R registerUser(@RequestBody RegisterVo registerVo) {
        memberService.register(registerVo);
        return R.ok();
    }

    //根据token获取用户信息
    @GetMapping("getMemberInfo")
    public R getMemberInfo(HttpServletRequest request) {
        //调用jwt工具类的方法。根据request对象获取头信息，返回用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        //查询数据库根据用户id获取用户信息
        UcenterMember member = memberService.getById(memberId);
        return R.ok().data("userInfo",member);
    }

    @GetMapping("getNewCustomer")
    public R getNewcustomer(){
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("is_disabled",true);
        List<UcenterMember> ucenterMember = memberService.list(wrapper);
        return R.ok().data("aclCustomerList",ucenterMember);
    }

    @PostMapping("updateCustomer")
    public R updateCustomer(String cutomer_id){
//        QueryWrapper<AclCustomer> wrapper = new QueryWrapper<>();
        UcenterMember ucenterMember = memberService.getById(cutomer_id);
        ucenterMember.setIsDisabled(false);
        memberService.updateById(ucenterMember);
        return R.ok();
    }
}

