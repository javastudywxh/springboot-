package com.wxh.email2.Service.impl;

import com.wxh.email2.Service.UserService;
import com.wxh.email2.entity.Users;
import com.wxh.email2.repo.AccountRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: WXH
 * @Date: 2022/9/20 - 09 - 20 - 12:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    AccountRepository repository;
    @Override
    public void insertUser(String password, String username,String email) {
        Users user=new Users();
        BCryptPasswordEncoder Encoder=new BCryptPasswordEncoder();
        user.setUsername(username);
        user.setPassword(Encoder.encode(password));
        user.setEmail(email);
        repository.save(user);
    }

    @Override
    public void updateUser(String username, String password) {
        BCryptPasswordEncoder Encoder=new BCryptPasswordEncoder();
        repository.updatePassWordByUsername(username,Encoder.encode(password));
    }
}
