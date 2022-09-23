package com.wxh.email2.controller;

import com.wxh.email2.entity.Users;
import com.wxh.email2.entity.request.RestBean;
import com.wxh.email2.repo.AccountRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: WXH
 * @Date: 2022/9/20 - 09 - 20 - 19:20
 */
@CrossOrigin
@Api(tags = "用户信息显示",description = "在主页显示用户的名称和权限")
@RestController
@RequestMapping("/api/user")
public class PageApiController {
    @Resource
    AccountRepository repository;
    @ApiResponse(code = 200,message = "显示成功")
    @ApiOperation("显示用户信息")
    @RequestMapping("/info")
    public RestBean<Users> info(){
        SecurityContext context= SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();
        Users user = repository.findUsersByUsername(context.getAuthentication().getName());
        user.setPassword("");
        return new RestBean<>(200,"请求成功",user);
    }
}
